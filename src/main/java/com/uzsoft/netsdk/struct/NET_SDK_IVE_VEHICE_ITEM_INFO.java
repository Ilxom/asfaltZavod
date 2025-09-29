package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 廖燕波
 * @create 2020/7/21
 * Description: 车牌识别
 */
public class NET_SDK_IVE_VEHICE_ITEM_INFO extends Structure {
	public NET_SDK_IVE_VEHICE_ITEM_INFO(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_IVE_VEHICE_ITEM_INFO() {
		super(ALIGN_NONE);
	}
	public static class ByReference extends NET_SDK_IVE_VEHICE_ITEM_INFO implements Structure.ByReference {
	}
	public static class ByValue extends NET_SDK_IVE_VEHICE_ITEM_INFO implements Structure.ByValue {
	}
	
	public int     begin_flag;         //开始标识，0x5a5a5a5a
	public int     data_type;          //0：JPG,1:YUV
	public int     image_type;         //0:原图，1：车牌
	    // 车牌, 车牌坐标, 车牌置信度
	public int     plateId;            /// ID，作为标识用（可参考人脸ID的实现方式）

	public int     plateCharCount;     // 车牌字符个数
	public byte[]       plate = new byte[32];	        // 车牌号码, utf8编码
	public byte[]       plateCharConfid= new byte[32];   // 车牌字符置信度

	public NET_SDK_IVE_RECT_T[]  ptPlateCharRect= new NET_SDK_IVE_RECT_T[32]; // 车牌字符左上角坐标
	public int		ptWidth;            // 坐标比例宽（用于画车牌跟踪框，或在画面中圈出车牌的位置）
	public int		ptHeight;           // 坐标比例高
	public NET_SDK_IVE_POINT_T	ptLeftTop;          // 车牌左上角坐标
	public NET_SDK_IVE_POINT_T	ptRightTop;         // 车牌右上角坐标
	public NET_SDK_IVE_POINT_T	ptLeftBottom;       // 车牌左下角坐标
	public NET_SDK_IVE_POINT_T	ptRightBottom;      // 车牌右下角坐标

	public short     plateWidth;            //车牌抓拍图片宽度
	public short     plateHeight;           //车牌抓拍图片高度

	public int     plateConfidence;       //置信度

	public int     plateIntensity;     //车牌亮度
    public byte      plateColor;         // 车牌颜色 // 0-蓝色 1-黑色 2-黄色 3-白色 4-绿色 5-红色 6-灰色 7-紫色(KISE)
    public byte      plateStyle;         // 车辆类型
    public byte      PlateColorRate;     // 颜色匹配程度；    
    public byte      vehicleColor;       // 车身颜色
    public int     plateAngleH;        //车牌水平倾斜角度
    public int     plateAngleV;        //车牌竖直倾斜角度

    public int     jpeg_len;           //Jpeg图片实际长度
    public int     jpeg_vir_len;       //Jpeg图片数据按32个字节对齐的总长度

    public byte[]        owner = new byte[32];          //车主名
    public int         listType;           //名单类型,0-未比对成功，1-陌生车辆，2-白名单，3-黑名单，产生比对类型【1-24】，每个分类预留8个空间,未比对【0,25-31】，未比对空间扩展到8
    public long     beginTime;           //开始时间
    public long     endTime;             //结束时间
    public byte      iVehicleDirect;    //车辆行驶方向，1未知 2靠近  3远离
    public byte[]       resrv = new byte[11];
    public int     end_flag;           //结束标识，0xa5a5a5a5
	

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
