package com.voltlife.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDTO {

    private String id_dsp;
    private Double pa;
    private Double qa;
    private Double sa;
    private Double uarms;
    private Double iarms;
    private Double pft;
    private Double pga;
    private Double freq;
    private Double epa_c;
    private Integer rele;
    private Double rssi_wifi;
    private String request_at;

    private Double temperatura;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer pressure;
    private Integer humidity;
    private String weather_main;
    private String weather_description;
    private String weather_icon;

    private Double wind_speed;
    private Integer wind_deg;
    private Double wind_gust;

    public String getId_dsp() {
        return id_dsp;
    }

    public void setId_dsp(String id_dsp) {
        this.id_dsp = id_dsp;
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

    public Double getEpa_c() {
        return epa_c;
    }

    public void setEpa_c(Double epa_c) {
        this.epa_c = epa_c;
    }

    public Integer getRele() {
        return rele;
    }

    public void setRele(Integer rele) {
        this.rele = rele;
    }

    public Double getRssi_wifi() {
        return rssi_wifi;
    }

    public void setRssi_wifi(Double rssi_wifi) {
        this.rssi_wifi = rssi_wifi;
    }

    public String getRequest_at() {
        return request_at;
    }

    public void setRequest_at(String request_at) {
        this.request_at = request_at;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
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

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public String getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(String weather_icon) {
        this.weather_icon = weather_icon;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Integer getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Integer wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(Double wind_gust) {
        this.wind_gust = wind_gust;
    }
}
