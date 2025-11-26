package top.andylanders.develop.entity.navidrome.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.andylanders.develop.entity.navidrome.CommonResponse;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Navidrome获取音乐文件夹列表响应实体类
 * @author Andy Landers
 * @date 2025-10-27
 * @description 从 Navidrome 服务器获取音乐文件夹列表的响应实体类定义。
 */
@XmlRootElement(name = "subsonic-response", namespace = "http://subsonic.org/restapi")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class GetMusicFoldersResponse extends CommonResponse {
    @XmlElement(name = "musicFolders")
    private List<MusicFolder> musicFolders;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class MusicFolder {
        @XmlAttribute(name = "id")
        private String id;
        @XmlAttribute(name = "name")
        private String name;
    }

}
/**
 * 样例返回XML
 *
 * <subsonic-response xmlns="http://subsonic.org/restapi" status="ok" version="1.1.1">
 * <span id="uas-port"/>
 * <musicFolders>
 * <musicFolder id="1" name="Music"/>
 * <musicFolder id="2" name="Movies"/>
 * <musicFolder id="3" name="Incoming"/>
 * </musicFolders>
 * </subsonic-response>
 */