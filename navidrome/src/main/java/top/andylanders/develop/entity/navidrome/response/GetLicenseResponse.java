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
