package Upload.Service;

import Entity.ExpertsInfo;

import java.util.List;

/**
 * 老师信息接口
 */
public interface ExpertInfoService {

    /**
     * 根据传入的类型进行排序
     * 一共三种类型的排序：
     * 1.按照咨询人数降序排序
     * 2.按照好评率降序排序
     * 3.按照咨询人数和好评率结合的推荐排序
     * @param type
     * @return 排序好的list集合
     */
    List<ExpertsInfo> expertsInfoList(String type);
}