package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * @author 廖燕波
 * @create 2018/6/25
 * @edit 2020/4/20
 * Description: 人脸检测
 */
public class NET_DVR_IVE_VFD_RESULT_FACE_DATA_INFO_T extends Structure {
	public NET_DVR_IVE_VFD_RESULT_FACE_DATA_INFO_T(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_DVR_IVE_VFD_RESULT_FACE_DATA_INFO_T() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_DVR_IVE_VFD_RESULT_FACE_DATA_INFO_T implements Structure.ByReference {
	}

	public static class ByValue extends NET_DVR_IVE_VFD_RESULT_FACE_DATA_INFO_T implements Structure.ByValue {
	}
	

    public int faceId;         /* face ID Number */
    public int ptWidth;        /*坐标比例宽*/
    public int ptHeight;       /*坐标比例高*/
    public NET_DVR_IVE_POINT_T ptLeftTop;      /* Left-Top     Face Coordinates    */
    public NET_DVR_IVE_POINT_T ptRightTop;     /* Right-Top    Face Coordinates    */
    public NET_DVR_IVE_POINT_T ptLeftBottom;   /* Left-Bottom  Face Coordinates    */
    public NET_DVR_IVE_POINT_T ptRightBottom;  /* Right-Bottom Face Coordinates    */
    public int nPose;          /* Face Pose                        */
    public int nConfidence;    /* Confidence Degree                */
    public int age;
    public int sex;
    public int dtFrames;
    public int featureSize;
    public NET_DVR_IVE_POINT_T stPosFaceImg;  //人脸左上角坐标(在检测源图片的位置)
    
  //begin 新增算法部分给的参数 
    public float                       feature_score;      // 特征值判断人脸可信度0~100

  	/*以下变量为IFaceDetectorEx接口支持，为负数时为无效状态*/
    public short                       eye_dist;           // 双眼距离
    public short                       blur;               // 模糊度

    public byte                        pose_est_score;     // 人脸姿态评估分数0~100
    public byte                        detect_score;       // 检测算法判断人脸可信度0~100
    public byte                        illumination;       // 抠图区域平均亮度
    public byte                        faceliveness;       // 活体0~100  

    public byte                        completeness;       // 遮挡0~100
    public byte                        glasses;            // 是否戴眼镜
    public byte                        wearmask;           // 是否戴口罩:0是未检测，1是未戴口罩 2是戴口罩
    public byte[] reserved1 = new byte[1];

    public float                       comprehensive_score;   // 综合评分 [90,100)是优秀， [80,90)是良好，[70,80)是一般，[60,70)是合格，[50,60)可选，[0,50)差。
  	//end 新增算法部分给的参数 
    public int                      temperature;        //体温

    public int                      foreheadX;          //额头坐标（临时添加）
    public int                      foreheadY;          //额头坐标（临时添加）
    
    
    public NET_DVR_IVE_POINT_T      stHotLeftTop;       //热成像人脸左上坐标
    public NET_DVR_IVE_POINT_T      stHotRightBottom;   //热成像人脸右下坐标
    public byte                      cTemperatureMode;   //热成像测温模式，0表示正常测温模式，1表示温度矫正模式
    public byte                      tempUnitsType;      //温度单位，0摄氏度，1华氏度
    public byte                      cTemperatureStatus; //体温状态，0体温正常，1低温异常，2高温异常
    public byte []                  reserved = new byte[5];
    
    public NET_DVR_IVE_VFD_RESULT_DATA_INFO_T stFaceImgData;

    @Override
    protected List<String> getFieldOrder() {
        List<Field> flist = getFieldList();
        List<String> list = new ArrayList<>(flist.size());
        for (Field f : flist) {
            list.add(f.getName());
        }
        return list;
    }
}