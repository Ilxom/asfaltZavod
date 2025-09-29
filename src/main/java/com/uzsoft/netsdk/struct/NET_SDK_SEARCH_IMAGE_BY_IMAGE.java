package com.uzsoft.netsdk.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NET_SDK_SEARCH_IMAGE_BY_IMAGE extends Structure {
	public NET_SDK_SEARCH_IMAGE_BY_IMAGE(Pointer p) {
		super(p,ALIGN_NONE);
		useMemory(p);
		read();
	}
	public NET_SDK_SEARCH_IMAGE_BY_IMAGE() {
		super(ALIGN_NONE);
	}

	public static class ByReference extends NET_SDK_SEARCH_IMAGE_BY_IMAGE implements Structure.ByReference {
	}

	public static class ByValue extends NET_SDK_SEARCH_IMAGE_BY_IMAGE implements Structure.ByValue {
	}

	public int	pageIndex;		//必填1、2、3...
	public int    pageSize;   //必填
	public int    similarity;		//相似度
	public int    resultCountLimit;		//结果个数限制
    public DD_TIME_EX   startTime = new DD_TIME_EX();
    public DD_TIME_EX    endTime = new DD_TIME_EX();
    public int searchType;//NET_SDK_SEARCH_IMAGE_BY_IMAGE_TYPE
    
    //结构体sfaceFeatures
    public NET_SDK_ST_SFACEFEATURES sfaceFeatures = new NET_SDK_ST_SFACEFEATURES();//SEARCH_IMAGE_BY_FACE_FEATURES 
    
    //结构体sfaceImgs
    public NET_SDK_FACE_IMG_INFO_CH faceImgs = new NET_SDK_FACE_IMG_INFO_CH();//SEARCH_IMAGE_BY_FACE_IMAGES

    //结构体sfaceFeatureGroups
    public NET_SDK_ST_SFACEFEATUREGROUPS sfaceFeatureGroups = new NET_SDK_ST_SFACEFEATUREGROUPS();//SEARCH_IMAGE_BY_FACE_FEATURE_GROUPS

    //结构体srecognizedFilter
    public NET_SDK_ST_SRECOGNIZEDFILTER srecognizedFilter = new NET_SDK_ST_SRECOGNIZEDFILTER();//SEARCH_IMAGE_BY_RECONGNIZED_FILTER
    
    //结构体sfaceImgData
    public NET_SDK_ST_SFACEIMGDATA sfaceImgData = new NET_SDK_ST_SFACEIMGDATA();//SEARCH_IMAGE_BY_FACE_IMAGE_DATA

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










