package cn.edu.bjfu.leetcode.nov;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

/**
 * @author chaos
 * @date 2021-11-03 21:53
 */
public class Day03 {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("张德刚,夏坤.浅析国家储备林建设的问题及对策[J].商业经济,2020(03):132-133+196.");
        list.add("孙鹏.国家储备林:为未来储备绿色宝藏[J].绿色中国,2019(19):32-35.");
        list.add("杨显.国储林：为国储材为民储财[J].中国林业产业,2020(06):14-17.");
        list.add("温臻.国家储备林建设浅析[J].陕西林业科技,2020,48(06):94-97.");
        list.add("梁曾飞,彭泰来,赵宇婷,戴前石.国家储备林建设现状与对策[J].林业科技通讯,2020(11):8-12.");
        list.add("刘春.林业信息化建设现状及技术应用[J].广东蚕业,2021,55(04):89-90.");
        list.add("袁首乾,陈秀娟,邓新禹.林业信息化技术发展现状及应用[J].农业与技术,2017,37(11):68-69.");
        list.add("张敏,孟玉珂.浅析林业信息化管理策略[J].广东蚕业,2021,55(07):121-122.");
        list.add("颜廷强,张巍.浅析我国林业信息化建设与管理[J].林产工业,2015,42(07):58-59.");
        list.add("井晖,王武魁,张靖然.森林抚育作业计划决策支持系统设计与应用[J].林业资源管理,2019(05):136-144.");
        list.add("罗正敏,赵本喜,张兴敏,吴亮.基于智慧林业巡检管理服务平台的林业信息化管理变革与创新[J].林业调查规划,2020,45(03):124-131.");
        list.add("张志军.“3S”技术在造林核查工作中的应用推广[J].防护林科技,2015(01):96-97.");
        list.add("周定辉.PDA和GIS在辽宁省营造林实绩核查中的应用[J].防护林科技,2016(12):87-88.");
        list.add("崔彦军,杨志刚,范丽红.3S的集成与发展及其在林业中的应用[J].吉林林业科技,2008(04):34-39.");
        list.add("魏佳楠,吴勇,林华剑,龚祎垄,宋昀,傅俊豪.基于WebGIS的自然资源“一张图”管理信息系统设计与实现[J].计算机应用与软件,2020,37(09):20-26.");
        list.add("陈张华.森林资源监测中林业3S技术的应用现状与展望[J].世界热带农业信息,2021(11):37-38.");
        list.add("吴瑞龙,何华贵,张鹏程,杨卫军,王明省,杨梅.基于GeoServer REST的矢量地图服务自动发布研究与应用[J].测绘地理信息,2021,46(S1):32-35.");
        list.add("代林海,秦荣波.Geoserver的WMS服务分析与应用[J].测绘,2021,44(02):67-70+78.");
        list.add("梁国峰,胡奇玮,白畯文,杨念东,杨海文,孟欢.开源GIS架构下的水库综合管理系统设计与实现[J].科学技术创新,2019(25):93-94.");
        list.add("陈志泊.GIS中栅格数据时空数据模型及其应用的研究[D].北京林业大学,2005.");
        list.add("戴瑶,段增强,艾东.基于GeoServer的国土空间规划野外调查辅助平台搭建与应用[J].测绘通报,2021(01):121-123+147.");
        list.add("李记,徐爱俊,张弘.基于WebGIS的国有林权管理信息系统研建[J].林业资源管理,2017(02):126-130.");
        list.add("姚智,张晓丽.基于WebGIS平台的森林郁闭度遥感反演信息系统研建[J].浙江农林大学学报,2015,32(03):392-398.");
        list.add("丁克奎,钟凯文,周旭斌,孙彩歌.基于WebSocket和GeoJSON的WebGIS的设计与实现[J].测绘通报,2015(02):109-112.");
        list.add("李冬.基于Spring的开源GIS城市管网的系统设计[J].科学技术创新,2020(27):95-96.");
        list.add("赵博霖.基于PDF地图的地理空间Web服务和微服务技术研究[D].西安电子科技大学,2020.");
        list.add("陈京华,国红,贺鹏,雷相东,卢军,刘宪钊.雄安新区国家储备林栽培模型设计[J].林业资源管理,2021(03):47-52.");
        list.add("张卫国.一种基于OpenLayers的GIS图形系统实现方案[J].工矿自动化,2015,41(09):71-73.");

        Collections.sort(list, (o1, o2) -> {
            Collator instance = Collator.getInstance(Locale.CHINA);
            return instance.compare(o1, o2);
        });
        System.out.println(list.size());
        list.forEach(System.out::println);

    }

}
