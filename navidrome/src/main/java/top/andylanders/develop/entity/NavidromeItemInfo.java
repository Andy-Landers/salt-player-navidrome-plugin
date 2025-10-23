package top.andylanders.develop.entity;

/**
 * Navidrome媒体源实体类
 * @author Andy Landers
 * @date 2025-10-23
 * @description 从Navidrome服务器获取的媒体项目实体类信息在此定义字段。
 */
public class NavidromeItemInfo {
    // 媒体项目ID
    private String id;

    // 父级ID
    private String parent;

    // 曲目名称
    private String title;

    // 专辑名称
    private String album;

    // 专辑中曲目序号
    private String track;

    // 艺术家名称
    private String artist;

    // 是否目录
    private boolean isDir;

    // 年代
    private String year;

    // 曲风
    private String genre;

    // 文件类型
    private String contentType;

    // 文件后缀
    private String suffix;

    // 专辑封面图片编号
    private String coverArt;

    // 文件大小
    private long size;

    // 曲目时长（单位：秒）
    private long duration;

    // 比特率
    private int bitRate;

    // 文件相对路径
    private String path;
}
