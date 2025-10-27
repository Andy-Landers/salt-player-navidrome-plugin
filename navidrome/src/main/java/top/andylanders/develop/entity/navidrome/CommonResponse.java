package top.andylanders.develop.entity.navidrome;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Navidrome通用返回头
 * @author Andy Landers
 * @date 2025-10-27
 * @description 通用返回头信息
 */

@Data
public class CommonResponse {

    @XmlRootElement(name = "subsonic-response")
    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    public class CommonResponseHead {

        // 握手状态
        @XmlAttribute(name = "status")
        private String status;

        // 服务端版本号
        @XmlAttribute(name = "version")
        private String version;

        // 接口命名空间
        @XmlAttribute(name = "xmlns")
        private String xmlns;

    }

}
