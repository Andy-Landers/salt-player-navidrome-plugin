package top.andylanders.develop.dict;

/**
 * Navidrome API枚举
 * @author Andy Landers
 * @date 2025-10-23
 * @description 通过此枚举可以快速通过URL构建器组装API请求URL
 */
public enum NavidromeAPIEnum {
    //TODO 接口列表待完善，接口来源地址：https://www.subsonic.org/pages/api.jsp

    // System
    PING("/ping", "服务器验活"),
    GET_LICENSE("/getLicense", "获取授权信息"),

    // Browsing
    GET_MUSIC_FOLDERS("/getMusicFolders", "获取音乐文件夹列表"),
    GET_INDEXES("/getIndexes", "获取索引列表"),
    GET_MUSIC_DIRECTORY("/getMusicDirectory", "获取媒体目录"),
    GET_GENRES("/getGenres", "获取所有流派"),
    GET_ARTISTS("/getArtists", "获取所有艺术家"),
    GET_ARTIST("/getArtist", "获取艺术家信息"),
    GET_ALBUM("/getAlbum", "获取专辑信息"),
    GET_SONG("/getSong", "获取歌曲详细信息"),
    GET_ARTIST_INFO("/getArtistInfo", "获取艺术家信息"),
    GET_ARTIST_INFO2("/getArtistInfo2", "获取艺术家信息"),
    GET_ALBUM_INFO("/getAlbumInfo", "获取专辑信息"),
    GET_ALBUM_INFO2("/getAlbumInfo2", "获取专辑信息"),
    GET_TOP_SONGS("/getTopSongs", "获取最热歌曲"),
    GET_SIMILAR_SONGS("/getSimilarSongs", "获取相似歌曲"),
    GET_SIMILAR_SONGS2("/getSimilarSongs2", "获取相似歌曲"),

    // Album & Song lists
    GET_ALBUM_LIST("/getAlbumList", "获取专辑列表"),
    GET_ALBUM_LIST2("/getAlbumList2", "获取专辑列表"),
    GET_RANDOM_SONGS("/getRandomSongs", "获取随机歌曲"),
    GET_SONGS_BY_GENRE("/getSongsByGenre", "获取流派歌曲"),
    GET_NOW_PLAYING("/getNowPlaying", "获取当前播放列表"),
    GET_STARRED("/getStarred", "获取收藏歌曲"),
    GET_STARRED2("/getStarred2", "获取收藏歌曲"),

    // Searching
    SEARCH2("/search2", "分页搜索"),
    SEARCH3("/search3", "分页搜索（支持根据ID3标签聚合）"),

    // Playlists
    GET_PLAYLISTS("/getPlaylists", "获取播放列表"),
    GET_PLAYLIST("/getPlaylist", "获取播放列表"),
    CREATE_PLAYLIST("/createPlaylist", "创建播放列表"),
    UPDATE_PLAYLIST("/updatePlaylist", "更新播放列表"),
    DELETE_PLAYLIST("/deletePlaylist", "删除播放列表"),

    // Media Retrieval
    STREAM("/stream", "流式传输"),
    DOWNLOAD("/download", "下载媒体文件"),
    HLS("/hls.m3u8", "HLS流式传输"),
    GET_COVER_ART("/getCoverArt", "获取封面图片"),
    GET_LYRICS("/getLyrics", "获取歌词"),
    GET_AVATAR("/getAvatar", "获取头像"),

    // Media Annotations
    STAR("/star", "收藏歌曲"),
    UNSTAR("/unstar", "取消收藏歌曲"),
    SCROBBLE("/scrobble", "打分歌曲"),
    SET_RATING("/setRating", "设置歌曲评分"),

    // Sharing
    GET_SHARES("/getShares", "获取分享列表"),
    CREATE_SHARE("/createShare", "创建分享"),
    UPDATE_SHARE("/updateShare", "更新分享"),
    DELETE_SHARE("/deleteShare", "删除分享"),

    // Podcasts
    GET_PODCASTS("/getPodcasts", "获取播客列表"),
    GET_NEWEST_PODCASTS("/getNewestPodcasts", "获取最新播客"),
    REFRESH_PODCASTS("/refreshPodcasts", "刷新播客"),
    CREATE_PODCAST_CHANNEL("/createPodcastChannel", "创建播客频道"),
    DELETE_PODCAST_CHANNEL("/deletePodcastChannel", "删除播客频道"),
    DELETE_PODCAST_EPISODE("/deletePodcastEpisode", "删除播客剧集"),
    DOWNLOAD_PODCAST_EPISODE("/downloadPodcastEpisode", "下载播客剧集"),

    ;
    private String val;
    private String desc;

    NavidromeAPIEnum(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return this.val;
    }
}
