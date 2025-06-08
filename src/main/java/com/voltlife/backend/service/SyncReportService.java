package com.voltlife.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voltlife.backend.model.Report;
import com.voltlife.backend.model.dtos.ReportDTO;
import com.voltlife.backend.repository.ReportRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SyncReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String REMOTE_URL = "http://187.58.58.185:9000/dado-salvo";
    private final RestTemplate restTemplate;

    public SyncReportService(ReportRepository reportRepository) {
        this.restTemplate = new RestTemplate();


    }

    @PostConstruct
    @Scheduled(fixedRate = 1000 * 60 * 60 * 12) // a cada 12 horas
    public void syncReports() {
        try {
            String json = restTemplate.getForObject(REMOTE_URL, String.class);
            List<ReportDTO> dtos = objectMapper.readValue(json, new TypeReference<>() {
            });

            List<Report> reports = dtos.stream()
                    .map(this::fromDTO)
                    .filter(r -> r != null)
                    .sorted(Comparator
                            .comparing(Report::getIdDsp, Comparator.nullsLast(String::compareTo))
                            .thenComparing(Report::getRequestAt, Comparator.nullsLast(LocalDateTime::compareTo)))
                    .collect(Collectors.toList());

            // Aplica o cálculo de consumoHora
            String lastIdDsp = null;
            Double lastEpaC = null;

            for (Report r : reports) {
                if (!r.getIdDsp().equals(lastIdDsp)) {
                    // Mudou o dispositivo, reinicia valores
                    lastEpaC = null;
                    lastIdDsp = r.getIdDsp();
                }

                if (lastEpaC != null) {
                    r.setConsumoHora(Math.max(0, r.getEpaC() - lastEpaC)); // evita valores negativos
                } else {
                    r.setConsumoHora(0.0);
                }

                lastEpaC = r.getEpaC();
            }

            reportRepository.saveAll(reports);
            System.out.println("[SYNC OK] " + reports.size() + " registros salvos.");

        } catch (Exception e) {
            System.err.println("[SYNC ERROR] Erro ao sincronizar relatórios: " + e.getMessage());
        }
    }

    private Report fromDTO(ReportDTO dto) {
        Report r = new Report();

        LocalDateTime requestAt = LocalDateTime.parse(dto.getRequest_at());
        r.setRequestAt(requestAt);

        // Data sem hora
        r.setDataColeta(java.sql.Date.valueOf(requestAt.toLocalDate()));

        // Hora sem data
        r.setHoraColeta(java.sql.Time.valueOf(requestAt.toLocalTime()));

        r.setIdDsp(dto.getId_dsp());
        r.setPa(dto.getPa());
        r.setQa(dto.getQa());
        r.setSa(dto.getSa());
        r.setUarms(dto.getUarms());
        r.setIarms(dto.getIarms());
        r.setPft(dto.getPft());
        r.setPga(dto.getPga());
        r.setFreq(dto.getFreq());
        r.setEpaC(dto.getEpa_c());
        r.setRele(dto.getRele());
        r.setRssiWifi(dto.getRssi_wifi());

        r.setTemperatura(dto.getTemperatura());
        r.setFeelsLike(dto.getFeels_like());
        r.setTempMin(dto.getTemp_min());
        r.setTempMax(dto.getTemp_max());
        r.setPressure(dto.getPressure());
        r.setHumidity(dto.getHumidity());
        r.setWeatherMain(dto.getWeather_main());
        r.setWeatherDescription(dto.getWeather_description());
        r.setWeatherIcon(dto.getWeather_icon());

        r.setWindSpeed(dto.getWind_speed());
        r.setWindDeg(dto.getWind_deg());
        r.setWindGust(dto.getWind_gust());

        return r;
    }
}

