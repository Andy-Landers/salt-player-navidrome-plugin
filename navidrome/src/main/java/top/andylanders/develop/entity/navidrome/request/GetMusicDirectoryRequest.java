package top.andylanders.develop.entity.navidrome.request;

import lombok.Data;
import top.andylanders.develop.entity.navidrome.CommonRequest;

@Data
public class GetMusicDirectoryRequest extends CommonRequest {
    private String id;
}
