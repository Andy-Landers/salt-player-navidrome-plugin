package top.andylanders.develop.entity.navidrome.response;

import lombok.Data;
import top.andylanders.develop.entity.navidrome.CommonResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subsonic-response")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GetLicenseResponse extends CommonResponse {

    @XmlElement(name = "license")
    private License license;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    public static class License {

        @javax.xml.bind.annotation.XmlAttribute(name = "valid")
        private boolean valid;

        @javax.xml.bind.annotation.XmlAttribute(name = "email")
        private String email;

        @javax.xml.bind.annotation.XmlAttribute(name = "licenseExpires")
        private String licenseExpires;
    }
}
/**
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <subsonic-response xmlns="http://subsonic.org/restapi" openSubsonic="true" serverVersion="0.58.0 (9dbe0c18)" status="ok" type="navidrome" version="1.16.1">
 *     <license valid="true"/>
 * </subsonic-response>
 */