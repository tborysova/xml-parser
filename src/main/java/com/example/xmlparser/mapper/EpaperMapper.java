package com.example.xmlparser.mapper;

import com.example.xmlparser.dto.EpaperRequestDto;
import com.example.xmlparser.entity.Epaper;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class EpaperMapper {

    public Epaper toEntity(final EpaperRequestDto epaperRequestDto, final String fileName) {
        Epaper epaper = new Epaper();
        epaper.setFileName(fileName);
        epaper.setNewspaperName(epaperRequestDto.getDeviceInfo().getAppInfo().getNewspaperName());
        epaper.setWidth(epaperRequestDto.getDeviceInfo().getScreenInfo().getWidth());
        epaper.setHeight(epaperRequestDto.getDeviceInfo().getScreenInfo().getHeight());
        epaper.setDpi(epaperRequestDto.getDeviceInfo().getScreenInfo().getDpi());
        epaper.setUploadTime(LocalDateTime.now());
        return epaper;
    }
}
