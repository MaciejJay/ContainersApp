package com.containers.model;

import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;

@Converter
public class SetConverter implements AttributeConverter<EnumSet<DamageTypeEnum>, String> {

    @Override
    public String convertToDatabaseColumn(EnumSet<DamageTypeEnum> attribute) {
        StringBuilder sb = new StringBuilder();
        for (DamageTypeEnum c : attribute) {
            sb.append(c).append(",");
        }
        return sb.toString();
    }

    public EnumSet<DamageTypeEnum> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            dbData = "";
        }
        EnumSet<DamageTypeEnum> enumSet = null; //default was a value I added.
        String[] persistencePermissions = StringUtils.trimAllWhitespace(dbData).toUpperCase().split(",");
        if (!StringUtils.isEmpty(StringUtils.trimAllWhitespace(dbData))) {
            try {
                for (String str : persistencePermissions) {
                    enumSet.add(DamageTypeEnum.valueOf(str));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return enumSet;
    }
}