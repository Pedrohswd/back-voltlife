package com.voltlife.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dispositivo
    private String idDsp;
    private Double pa;
    private Double qa;
    private Double sa;
    private Double uarms;
    private Double iarms;
    private Double pft;
    private Double pga;
    private Double freq;
    private Double epaC;
    private Integer rele;
    private Double rssiWifi;
    private Double consumoHora;
    @Temporal(TemporalType.DATE)
    private Date dataColeta;
    @Temporal(TemporalType.TIME)
    private Date horaColeta;

    private LocalDateTime requestAt;

    // Clima
    private Double temperatura;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIcon;

    // Vento
    private Double windSpeed;
    private Integer windDeg;
    private Double windGust;

    
    public Report() {

    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Date getHoraColeta() {
        return horaColeta;
    }

    public void setHoraColeta(Date horaColeta) {
        this.horaColeta = horaColeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdDsp() {
        return idDsp;
    }

    public void setIdDsp(String idDsp) {
        this.idDsp = idDsp;
    }

    public Double getPa() {
        return pa;
    }

    public void setPa(Double pa) {
        this.pa = pa;
    }

    public Double getQa() {
        return qa;
    }

    public void setQa(Double qa) {
        this.qa = qa;
    }

    public Double getSa() {
        return sa;
    }

    public void setSa(Double sa) {
        this.sa = sa;
    }

    public Double getUarms() {
        return uarms;
    }

    public void setUarms(Double uarms) {
        this.uarms = uarms;
    }

    public Double getIarms() {
        return iarms;
    }

    public Double getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(Double consumoHora) {
        this.consumoHora = consumoHora;
    }

    public void setIarms(Double iarms) {
        this.iarms = iarms;
    }

    public Double getPft() {
        return pft;
    }

    public void setPft(Double pft) {
        this.pft = pft;
    }

    public Double getPga() {
        return pga;
    }

    public void setPga(Double pga) {
        this.pga = pga;
    }

    public Double getFreq() {
        return freq;
    }

    public void setFreq(Double freq) {
        this.freq = freq;
    }

    public Double getEpaC() {
        return epaC;
    }

    public void setEpaC(Double epaC) {
        this.epaC = epaC;
    }

    public Integer getRele() {
        return rele;
    }

    public void setRele(Integer rele) {
        this.rele = rele;
    }

    public Double getRssiWifi() {
        return rssiWifi;
    }

    public void setRssiWifi(Double rssiWifi) {
        this.rssiWifi = rssiWifi;
    }

    public LocalDateTime getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(LocalDateTime requestAt) {
        this.requestAt = requestAt;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Integer windDeg) {
        this.windDeg = windDeg;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }
}
