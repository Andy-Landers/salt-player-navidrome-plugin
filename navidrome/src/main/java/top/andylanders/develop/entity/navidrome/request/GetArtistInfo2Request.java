package top.andylanders.develop.entity.navidrome.request;

import lombok.Data;
import top.andylanders.develop.entity.navidrome.CommonRequest;

@Data
public class GetArtistInfo2Request extends CommonRequest {
    private String id;
    private Integer count;
    private String includeNotPresent;
}
