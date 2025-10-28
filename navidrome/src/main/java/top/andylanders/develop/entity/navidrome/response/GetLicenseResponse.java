package top.andylanders.develop.entity.navidrome.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.andylanders.develop.entity.navidrome.CommonResponse;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "subsonic-response", namespace = "http://subsonic.org/restapi")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class GetLicenseResponse extends CommonResponse {

    @XmlElement(name = "license")
    private License license;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class License {

        @XmlAttribute(name = "valid")
        private boolean valid;

        @XmlAttribute(name = "email")
        private String email;

        @XmlAttribute(name = "licenseExpires")
        private String licenseExpires;
    }
}
/**
 * 样例返回
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <subsonic-response xmlns="http://subsonic.org/restapi" openSubsonic="true" serverVersion="0.58.0 (9dbe0c18)" status="ok" type="navidrome" version="1.16.1">
 *     <license valid="true"/>
 * </subsonic-response>
 */