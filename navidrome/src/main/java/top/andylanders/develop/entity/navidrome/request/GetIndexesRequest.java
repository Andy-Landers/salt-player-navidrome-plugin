package top.andylanders.develop.entity.navidrome.request;

import lombok.Data;
import top.andylanders.develop.entity.navidrome.CommonRequest;

@Data
public class GetIndexesRequest extends CommonRequest {
    private String musicFolderId;
    private String ifModifiedSince;
}
