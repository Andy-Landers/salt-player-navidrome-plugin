package top.andylanders.develop.entity.navidrome;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Navidrome通用返回头
 * @author Andy Landers
 * @date 2025-10-27
 * @description 通用返回头信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class CommonResponse {

    // 握手状态
    @XmlAttribute(name = "status")
    private String status;

    // 服务端版本号
    @XmlAttribute(name = "version")
    private String version;

    // 接口命名空间
    @XmlAttribute(name = "xmlns")
    private String xmlns;

    // 添加其他可能的根元素属性
    @XmlAttribute(name = "openSubsonic")
    private Boolean openSubsonic;

    @XmlAttribute(name = "serverVersion")
    private String serverVersion;

    @XmlAttribute(name = "type")
    private String type;
}
