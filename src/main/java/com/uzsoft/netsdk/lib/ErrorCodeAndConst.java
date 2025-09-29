package com.uzsoft.netsdk.lib;

public class ErrorCodeAndConst {
	
	 /************************************************************************
     ** 常量定义
     ***********************************************************************/
	//连接登录方式
	public static final int NET_SDK_CONNECT_TCP     = 0;			//TCP方式登陆
	public static final int NET_SDK_CONNECT_NAT     = 1;			//NAT方式登陆
	public static final int NET_SDK_CONNECT_NAT20 	= 2;			//用NAT2.0连接

	//设备类型
	public static final int NET_SDK_DVR             = 0;
	public static final int NET_SDK_DVS             = 1;
	public static final int NET_SDK_IPCAMERA        = 2;
	public static final int NET_SDK_NVR             = 3;
	public static final int NET_SDK_SUPERDVR        = 4;
	public static final int NET_SDK_DECODER         = 5;
	public static final int NET_SDK_N_DVR           = 6;
	//设备码流类型
	public static final int NET_SDK_MAIN_STREAM = 0;//主码流
    public static final int NET_SDK_SUB_STREAM = 1;//子码流
    public static final int NET_SDK_THIRD_STREAM = 2;//第3码流
    public static final int NET_SDK_FOURTH_STREAM = 3;//第4码流
	// IPC订阅智能事件类型
	public static final int NET_DVR_SMART_AVD = 0;            // 视频异常诊断功能检测
	public static final int NET_DVR_SMART_VFD= 1;           // 人脸检测
	public static final int NET_DVR_SMART_VFD_MATCH= 2;     //人脸比对
	public static final int NET_DVR_SMART_PEA= 3;                  // 区域入侵
	public static final int NET_DVR_SMART_OSC= 4;                  // 物品遗留及丢失
	public static final int NET_DVR_SMART_CPC= 5;                  // 人流量统计
	public static final int NET_DVR_SMART_CDD= 6;                 // 人群密度检测
	public static final int NET_DVR_SMART_IPD= 7;                  // 人员入侵侦测
	public static final int NET_IPC_SMART_VIHICLE= 8; 			//车牌识别
	public static final int NET_IPC_SMART_AOIENTRY= 9;             //进入区域
	public static final int NET_IPC_SMART_AOILEAVE= 10;            //离开区域
	public static final int NET_DVR_SMART_VFD_MATCH_FAILED= 11;     //人脸比对失败。针对陌生人
	public static final int NET_IPC_SMART_PASSLINE= 12;             //过线统计
	//智能报警回调类型
	public static final int NET_SDK_N9000_ALARM_TYPE_VFD                 = 12;//人脸侦测（目前仅IPC）
	public static final int NET_SDK_N9000_ALARM_TYPE_CDD                 = 13;          ////Crowdy density
	public static final int NET_SDK_N9000_ALARM_TYPE_IPD                 = 14;         ////people intrusion
	public static final int NET_SDK_N9000_ALARM_TYPE_CPC                 = 15;           ////people counting
	public static final int NET_SDK_N9000_ALARM_TYPE_FACE_MATCH          = 16;    ////人脸比对报警 for nvr 9000
	public static final int NET_SDK_N9000_ALARM_TYPE_FACE_MATCH_FOR_IPC  = 17;    ////人脸比对报警 for ipc
	public static final int NET_SDK_N9000_ALARM_TYPE_PEA_FOR_IPC         = 18;           ////越界侦测与区域入侵侦测
	public static final int NET_SDK_N9000_ALARM_TYPE_TRAJECT             = 19;
    public static final int NET_SDK_N9000_ALARM_TYPE_AOILEAVE            = 22;//离开区域for ipc
	public static final int NET_SDK_N9000_ALARM_TYPE_PASSLINE            = 23;//passline counting for ipc
	
	//测温相关能力集
	public static final int supportThermometry                = 0;//口罩跟体温
	public static final int supportVfd                        = 1;//人脸检测
	public static final int supportVfdMatch                   = 2;//人脸比对
	public static final int supportThermal                    = 3;////热成像
	public static final int supportPassLine                   = 4;//过线统计
	//智能能力集
	public static final int intelist_enable                   = 0;//是否包含智能能力集列表
	public static final int intelist_Perimeter                = 1;//区域入侵
	public static final int intelist_Tripwire                 = 2;//绊线侦测
	public static final int intelist_Osc                      = 3;//物品看护
	public static final int intelist_Avd                      = 4;//异常侦测
	public static final int intelist_Cpc                      = 5;//人流量统计
	public static final int intelist_Cdd                      = 6;//人群密度检测
	public static final int intelist_Ipd                      = 7;//人员入侵侦测
	public static final int intelist_Vfd                      = 8;//人脸抓拍
	public static final int intelist_Vfd_Match                = 9;//人脸比对
	public static final int intelist_Vehice                   = 10;//车牌检测
	public static final int intelist_AoiEntry                 = 11;//进入区域
	public static final int intelist_AoiLeave                 = 12;//离开区域
	public static final int intelist_PassLineCount            = 13;//过线统计
	public static final int intelist_Vfd_Detect               = 14;//人脸侦测
	public static final int intelist_Traffic                  = 15;//流量统计
	public static final int intelist_Thermal                  = 16; //热成像测温
	
	
	public static final int NET_SDK_GET_FACE_MATCH_SUPPOR         = 1;//in:NULL, out:DWORD  值为1下面的依次递增
    //目标组
	public static final int NET_SDK_GET_FACE_INFO_GROUP_LIST      = 2;//queryFacePersonnalInfoGroupList in:NULL, out:NET_SDK_FACE_INFO_GROUP_ITEM list
	public static final int NET_SDK_ADD_FACE_INFO_GROUP           = 3;//createFacePersonnalInfoGroup in:NET_SDK_FACE_INFO_GROUP_ADD out:NULL
	public static final int NET_SDK_SET_FACE_INFO_GROUP           = 4;//editFacePersonnalInfoGroup in:NET_SDK_FACE_INFO_GROUP_ITEM  out:NULL
	public static final int NET_SDK_DEL_FACE_INFO_GROUP           = 5;//delFacePersonnalInfoGroups in:NET_SDK_FACE_INFO_GROUP_DEL  out:NULL
    //目标
	public static final int NET_SDK_GET_FACE_INFO_LIST            = 6;//queryFacePersonnalInfoList in:NET_SDK_FACE_INFO_LIST_GET, out:NET_SDK_FACE_INFO_LIST
	public static final int NET_SDK_ADD_FACE_INFO                 = 7;//createFacePersonnalInfo in:NET_SDK_FACE_INFO_ADD out:NULL
	public static final int NET_SDK_SET_FACE_INFO                 = 8;//editFacePersonnalInfo in:NET_SDK_FACE_INFO_EDIT out:NULL
	public static final int NET_SDK_DEL_FACE_INFO                 = 9;//delFacePersonnalInfo in:NET_SDK_FACE_INFO_DEL  out:NULL
    //对比报警配置
	public static final int NET_SDK_GET_FACE_MATCH_ALARM          = 10;//queryFaceMatchAlarm  in:NULL out:NET_SDK_FACE_MATCH_ALARM
	public static final int NET_SDK_SET_FACE_MATCH_ALARM          = 11;//editFaceMatchAlarm in:NET_SDK_FACE_MATCH_ALARM out:NULL
    //请求人脸目标图片
	public static final int NET_SDK_GET_FACE_INFO_IMG             = 12;//requestFacePersonnalInfoImage in:NET_SDK_FACE_INFO_IMG_GET out:NET_SDK_FACE_INFO_IMG_DATA
    //以图搜图 searchImageByImage
	public static final int NET_SDK_SEARCH_IMAGE_BY_IMG           = 13; //searchImageByImage in:NET_SDK_SEARCH_IMAGE_BY_IMAGE out:NET_SDK_SEARCH_IMAGE_BY_IMAGE_LIST
    //查询通道人脸图片
	public static final int NET_SDK_SEARCH_CH_SNAP_FACE_IMG_LIST  = 14;//queryChSnapFaceImageList in:NET_SDK_CH_SNAP_FACE_IMG_LIST_SEARCH out:NET_SDK_CH_SNAP_FACE_IMG_LIST
    //请求通道人脸图片数据
	public static final int NET_SDK_SEARCH_CH_SNAP_FACE_IMG       = 15;//requestChSnapFaceImage in:NET_SDK_FACE_IMG_INFO_CH out:NET_SDK_FACE_INFO_IMG_DATA
	//给IPC添加人脸图片
	public static final int NET_SDK_ADD_FACE_IPC = 16;
	//删除IPC人脸图片
	public static final int NET_SDK_DEL_FACE_IPC = 17;
	//编辑IPC人脸图片
	public static final int NET_SDK_EDIT_FACE_IPC = 18;
	//查询IPC人脸图片
	public static final int NET_SDK_GET_FACE_IPC_LIST = 19;
	
	public static final int NET_SDK_COPY_FACE_INFO = 20;
	public static final int NET_SDK_SEARCH_IMAGE_BY_IMG_V2 = 21;
	public static final int NET_SDK_SEARCH_SMART_TARGET_LIST = 22;
	public static final int NET_SDK_SEARCH_SMART_TARGET_IMG = 23;
	public static final int NET_SDK_GET_FACE_IMG_STATISTIC_V2 = 24;
	public static final int NET_SDK_GET_FACE_INFO = 25;
	
	public static final int NET_SDK_FACE_INFO_GROUP_PROPERTY_ALLOW = 0;//白名单
	public static final int NET_SDK_FACE_INFO_GROUP_PROPERTY_REJECT = 1;//黑名单
	public static final int NET_SDK_FACE_INFO_GROUP_PROPERTY_LIMITED = 2;
	
	
	
    public static final int NET_SERIALNO_LEN                      = 48;             // 设备序列号字符长度
    public static final int NET_CFG_Max_VideoColor                = 24;             // 每个通道最大视频输入颜色配置数量
    public static final int NET_CFG_Custom_Title_Len              = 1024;           // 自定义标题名称长度(扩充到1024)
    public static final int NET_CFG_Custom_TitleType_Len          = 32;             // 自定义标题类型长度
    public static final int NET_CFG_Max_Video_Widget_Cover        = 16;             // 编码区域覆盖最大数量
    public static final int NET_CFG_Max_Video_Widget_Custom_Title = 8;              // 编码物件自定义标题最大数量
    public static final int NET_CFG_Max_Video_Widget_Sensor_Info  = 2;              // 编码物件叠加传感器信息的最大数目
    public static final int NET_CFG_Max_Description_Num           = 4;              // 叠加区域描述信息的最大个数
    
    public static final int PTZ_CMD_STOP = 0;
    
    public static final int NET_EXTPTZ_LEFTTOP = 5;
    public static final int NET_EXTPTZ_LEFTDOWN = 6;
    public static final int NET_EXTPTZ_RIGHTTOP = 7;
    public static final int NET_EXTPTZ_RIGHTDOWN = 8;

    
    public static final int NET_PTZ_UP_CONTROL = 3;//上
    public static final int NET_PTZ_DOWN_CONTROL = 4; //下
    public static final int NET_PTZ_LEFT_CONTROL = 1; //左
    public static final int NET_PTZ_RIGHT_CONTROL = 2; //右
    public static final int NET_PTZ_ZOOM_ADD_CONTROL = 11; //变倍+
    public static final int NET_PTZ_ZOOM_DEC_CONTROL = 12; //变倍-
    public static final int NET_PTZ_FOCUS_ADD_CONTROL = 9; //调焦+
    public static final int NET_PTZ_FOCUS_DEC_CONTROL = 10; //调焦-
    public static final int NET_PTZ_APERTURE_ADD_CONTROL = 13; //光圈+
    public static final int NET_PTZ_APERTURE_DEC_CONTROL = 14; //光圈-
    public static final int NET_PTZ_POINT_MOVE_CONTROL = 16; //转至预置点
    public static final int NET_PTZ_POINT_SET_CONTROL = 15; //设置
    public static final int NET_PTZ_POINT_DEL_CONTROL = 17; //删除
    public static final int NET_PTZ_POINT_LOOP_CONTROL = 22; //点间巡航
    //public static final int NET_PTZ_LAMP_CONTROL = NET_PTZ_POINT_LOOP_CONTROL+1; //灯光雨刷
    
	// 错误类型代号，对应CLIENT_GetLastError接口的返回值, 十进制
    public static final int NET_NOERROR                         =  0;               // 没有错误
    public static final int NET_ERROR                           = -1;               // 未知错误
    public static final int NET_SYSTEM_ERROR                    = (0x80000000|1);   // Windows系统出错
    public static final int NET_NETWORK_ERROR                   = (0x80000000|2);   // 网络错误，可能是因为网络超时
    public static final int NET_DEV_VER_NOMATCH                 = (0x80000000|3);   // 设备协议不匹配
    public static final int NET_INVALID_HANDLE                  = (0x80000000|4);   // 句柄无效
    public static final int NET_OPEN_CHANNEL_ERROR              = (0x80000000|5);   // 打开通道失败
    public static final int NET_CLOSE_CHANNEL_ERROR             = (0x80000000|6);   // 关闭通道失败
    public static final int NET_ILLEGAL_PARAM                   = (0x80000000|7);   // 用户参数不合法
    public static final int NET_SDK_INIT_ERROR                  = (0x80000000|8);   // SDK初始化出错
    public static final int NET_SDK_UNINIT_ERROR                = (0x80000000|9);   // SDK清理出错
    public static final int NET_RENDER_OPEN_ERROR               = (0x80000000|10);  // 申请render资源出错
    public static final int NET_DEC_OPEN_ERROR                  = (0x80000000|11);  // 打开解码库出错
    public static final int NET_DEC_CLOSE_ERROR                 = (0x80000000|12);  // 关闭解码库出错
    public static final int NET_MULTIPLAY_NOCHANNEL             = (0x80000000|13);  // 多画面预览中检测到通道数为0
    public static final int NET_TALK_INIT_ERROR                 = (0x80000000|14);  // 录音库初始化失败
    public static final int NET_TALK_NOT_INIT                   = (0x80000000|15);  // 录音库未经初始化
    public static final int NET_TALK_SENDDATA_ERROR             = (0x80000000|16);  // 发送音频数据出错
    public static final int NET_REAL_ALREADY_SAVING             = (0x80000000|17);  // 实时数据已经处于保存状态
    public static final int NET_NOT_SAVING                      = (0x80000000|18);  // 未保存实时数据
    public static final int NET_OPEN_FILE_ERROR                 = (0x80000000|19);  // 打开文件出错
    public static final int NET_PTZ_SET_TIMER_ERROR             = (0x80000000|20);  // 启动云台控制定时器失败
    public static final int NET_RETURN_DATA_ERROR               = (0x80000000|21);  // 对返回数据的校验出错
    public static final int NET_INSUFFICIENT_BUFFER             = (0x80000000|22);  // 没有足够的缓存
    public static final int NET_NOT_SUPPORTED                   = (0x80000000|23);  // 当前SDK未支持该功能
    public static final int NET_NO_RECORD_FOUND                 = (0x80000000|24);  // 查询不到录像
    public static final int NET_NOT_AUTHORIZED                  = (0x80000000|25);  // 无操作权限
    public static final int NET_NOT_NOW                         = (0x80000000|26);  // 暂时无法执行
    public static final int NET_NO_TALK_CHANNEL                 = (0x80000000|27);  // 未发现对讲通道
    public static final int NET_NO_AUDIO                        = (0x80000000|28);  // 未发现音频
    public static final int NET_NO_INIT                         = (0x80000000|29);  // 网络SDK未经初始化
    public static final int NET_DOWNLOAD_END                    = (0x80000000|30);  // 下载已结束
    public static final int NET_EMPTY_LIST                      = (0x80000000|31);  // 查询结果为空
    public static final int NET_ERROR_GETCFG_SYSATTR            = (0x80000000|32);  // 获取系统属性配置失败
    public static final int NET_ERROR_GETCFG_SERIAL             = (0x80000000|33);  // 获取序列号失败
    public static final int NET_ERROR_GETCFG_GENERAL            = (0x80000000|34);  // 获取常规属性失败
    public static final int NET_ERROR_GETCFG_DSPCAP             = (0x80000000|35);  // 获取DSP能力描述失败
    public static final int NET_ERROR_GETCFG_NETCFG             = (0x80000000|36);  // 获取网络配置失败
    public static final int NET_ERROR_GETCFG_CHANNAME           = (0x80000000|37);  // 获取通道名称失败
    public static final int NET_ERROR_GETCFG_VIDEO              = (0x80000000|38);  // 获取视频属性失败
    public static final int NET_ERROR_GETCFG_RECORD             = (0x80000000|39);  // 获取录象配置失败
    public static final int NET_ERROR_GETCFG_PRONAME            = (0x80000000|40);  // 获取解码器协议名称失败
    public static final int NET_ERROR_GETCFG_FUNCNAME           = (0x80000000|41);  // 获取232串口功能名称失败
    public static final int NET_ERROR_GETCFG_485DECODER         = (0x80000000|42);  // 获取解码器属性失败
    public static final int NET_ERROR_GETCFG_232COM             = (0x80000000|43);  // 获取232串口配置失败
    public static final int NET_ERROR_GETCFG_ALARMIN            = (0x80000000|44);  // 获取外部报警输入配置失败
    public static final int NET_ERROR_GETCFG_ALARMDET           = (0x80000000|45);  // 获取动态检测报警失败
    public static final int NET_ERROR_GETCFG_SYSTIME            = (0x80000000|46);  // 获取设备时间失败
    public static final int NET_ERROR_GETCFG_PREVIEW            = (0x80000000|47);  // 获取预览参数失败
    public static final int NET_ERROR_GETCFG_AUTOMT             = (0x80000000|48);  // 获取自动维护配置失败
    public static final int NET_ERROR_GETCFG_VIDEOMTRX          = (0x80000000|49);  // 获取视频矩阵配置失败
    public static final int NET_ERROR_GETCFG_COVER              = (0x80000000|50);  // 获取区域遮挡配置失败
    public static final int NET_ERROR_GETCFG_WATERMAKE          = (0x80000000|51);  // 获取图象水印配置失败
    public static final int NET_ERROR_GETCFG_MULTICAST          = (0x80000000|52);  // 获取配置失败位置：组播端口按通道配置
    public static final int NET_ERROR_SETCFG_GENERAL            = (0x80000000|55);  // 修改常规属性失败
    public static final int NET_ERROR_SETCFG_NETCFG             = (0x80000000|56);  // 修改网络配置失败
    public static final int NET_ERROR_SETCFG_CHANNAME           = (0x80000000|57);  // 修改通道名称失败
    public static final int NET_ERROR_SETCFG_VIDEO              = (0x80000000|58);  // 修改视频属性失败
    public static final int NET_ERROR_SETCFG_RECORD             = (0x80000000|59);  // 修改录象配置失败
    public static final int NET_ERROR_SETCFG_485DECODER         = (0x80000000|60);  // 修改解码器属性失败
    public static final int NET_ERROR_SETCFG_232COM             = (0x80000000|61);  // 修改232串口配置失败
    public static final int NET_ERROR_SETCFG_ALARMIN            = (0x80000000|62);  // 修改外部输入报警配置失败
    public static final int NET_ERROR_SETCFG_ALARMDET           = (0x80000000|63);  // 修改动态检测报警配置失败
    public static final int NET_ERROR_SETCFG_SYSTIME            = (0x80000000|64);  // 修改设备时间失败
    public static final int NET_ERROR_SETCFG_PREVIEW            = (0x80000000|65);  // 修改预览参数失败
    public static final int NET_ERROR_SETCFG_AUTOMT             = (0x80000000|66);  // 修改自动维护配置失败
    public static final int NET_ERROR_SETCFG_VIDEOMTRX          = (0x80000000|67);  // 修改视频矩阵配置失败
    public static final int NET_ERROR_SETCFG_COVER              = (0x80000000|68);  // 修改区域遮挡配置失败
    public static final int NET_ERROR_SETCFG_WATERMAKE          = (0x80000000|69);  // 修改图象水印配置失败
    public static final int NET_ERROR_SETCFG_WLAN               = (0x80000000|70);  // 修改无线网络信息失败
    public static final int NET_ERROR_SETCFG_WLANDEV            = (0x80000000|71);  // 选择无线网络设备失败
    public static final int NET_ERROR_SETCFG_REGISTER           = (0x80000000|72);  // 修改主动注册参数配置失败
    public static final int NET_ERROR_SETCFG_CAMERA             = (0x80000000|73);  // 修改摄像头属性配置失败
    public static final int NET_ERROR_SETCFG_INFRARED           = (0x80000000|74);  // 修改红外报警配置失败
    public static final int NET_ERROR_SETCFG_SOUNDALARM         = (0x80000000|75);  // 修改音频报警配置失败
    public static final int NET_ERROR_SETCFG_STORAGE            = (0x80000000|76);  // 修改存储位置配置失败
    public static final int NET_AUDIOENCODE_NOTINIT             = (0x80000000|77);  // 音频编码接口没有成功初始化
    public static final int NET_DATA_TOOLONGH                   = (0x80000000|78);  // 数据过长
    public static final int NET_UNSUPPORTED                     = (0x80000000|79);  // 设备不支持该操作
    public static final int NET_DEVICE_BUSY                     = (0x80000000|80);  // 设备资源不足
    public static final int NET_SERVER_STARTED                  = (0x80000000|81);  // 服务器已经启动
    public static final int NET_SERVER_STOPPED                  = (0x80000000|82);  // 服务器尚未成功启动
    public static final int NET_LISTER_INCORRECT_SERIAL         = (0x80000000|83);  // 输入序列号有误
    public static final int NET_QUERY_DISKINFO_FAILED           = (0x80000000|84);  // 获取硬盘信息失败
    public static final int NET_ERROR_GETCFG_SESSION            = (0x80000000|85);  // 获取连接Session信息
    public static final int NET_USER_FLASEPWD_TRYTIME           = (0x80000000|86);  // 输入密码错误超过限制次数
    public static final int NET_LOGIN_ERROR_PASSWORD            = (0x80000000|100); // 密码不正确
    public static final int NET_LOGIN_ERROR_USER                = (0x80000000|101); // 帐户不存在
    public static final int NET_LOGIN_ERROR_TIMEOUT             = (0x80000000|102); // 等待登录返回超时
    public static final int NET_LOGIN_ERROR_RELOGGIN            = (0x80000000|103); // 帐号已登录
    public static final int NET_LOGIN_ERROR_LOCKED              = (0x80000000|104); // 帐号已被锁定
    public static final int NET_LOGIN_ERROR_BLACKLIST           = (0x80000000|105); // 帐号已被列为黑名单
    public static final int NET_LOGIN_ERROR_BUSY                = (0x80000000|106); // 资源不足，系统忙
    public static final int NET_LOGIN_ERROR_CONNECT             = (0x80000000|107); // 登录设备超时，请检查网络并重试
    public static final int NET_LOGIN_ERROR_NETWORK             = (0x80000000|108); // 网络连接失败
    public static final int NET_LOGIN_ERROR_SUBCONNECT          = (0x80000000|109); // 登录设备成功，但无法创建视频通道，请检查网络状况
    public static final int NET_LOGIN_ERROR_MAXCONNECT          = (0x80000000|110); // 超过最大连接数
    public static final int NET_LOGIN_ERROR_PROTOCOL3_ONLY      = (0x80000000|111); // 只支持3代协议
    public static final int NET_LOGIN_ERROR_UKEY_LOST           = (0x80000000|112); // 未插入U盾或U盾信息错误
    public static final int NET_LOGIN_ERROR_NO_AUTHORIZED       = (0x80000000|113); // 客户端IP地址没有登录权限
    public static final int NET_LOGIN_ERROR_USER_OR_PASSOWRD    = (0x80000000|117); // 账号或密码错误 
    public static final int NET_LOGIN_ERROR_DEVICE_NOT_INIT		= (0x80000000|118);	// 设备尚未初始化，不能登录，请先初始化设备
    public static final int NET_RENDER_SOUND_ON_ERROR           = (0x80000000|120); // Render库打开音频出错
    public static final int NET_RENDER_SOUND_OFF_ERROR          = (0x80000000|121); // Render库关闭音频出错
    public static final int NET_RENDER_SET_VOLUME_ERROR         = (0x80000000|122); // Render库控制音量出错
    public static final int NET_RENDER_ADJUST_ERROR             = (0x80000000|123); // Render库设置画面参数出错
    public static final int NET_RENDER_PAUSE_ERROR              = (0x80000000|124); // Render库暂停播放出错
    public static final int NET_RENDER_SNAP_ERROR               = (0x80000000|125); // Render库抓图出错
    public static final int NET_RENDER_STEP_ERROR               = (0x80000000|126); // Render库步进出错
    public static final int NET_RENDER_FRAMERATE_ERROR          = (0x80000000|127); // Render库设置帧率出错
    public static final int NET_RENDER_DISPLAYREGION_ERROR      = (0x80000000|128); // Render库设置显示区域出错
    public static final int NET_RENDER_GETOSDTIME_ERROR         = (0x80000000|129); // Render库获取当前播放时间出错
    public static final int NET_GROUP_EXIST                     = (0x80000000|140); // 组名已存在
    public static final int NET_GROUP_NOEXIST                   = (0x80000000|141); // 组名不存在
    public static final int NET_GROUP_RIGHTOVER                 = (0x80000000|142); // 组的权限超出权限列表范围
    public static final int NET_GROUP_HAVEUSER                  = (0x80000000|143); // 组下有用户，不能删除
    public static final int NET_GROUP_RIGHTUSE                  = (0x80000000|144); // 组的某个权限被用户使用，不能删除
    public static final int NET_GROUP_SAMENAME                  = (0x80000000|145); // 新组名同已有组名重复
    public static final int NET_USER_EXIST                      = (0x80000000|146); // 用户已存在
    public static final int NET_USER_NOEXIST                    = (0x80000000|147); // 用户不存在
    public static final int NET_USER_RIGHTOVER                  = (0x80000000|148); // 用户权限超出组权限
    public static final int NET_USER_PWD                        = (0x80000000|149); // 保留帐号，不容许修改密码
    public static final int NET_USER_FLASEPWD                   = (0x80000000|150); // 密码不正确
    public static final int NET_USER_NOMATCHING                 = (0x80000000|151); // 密码不匹配
    public static final int NET_USER_INUSE                      = (0x80000000|152); // 账号正在使用中
    public static final int NET_ERROR_GETCFG_ETHERNET           = (0x80000000|300); // 获取网卡配置失败
    public static final int NET_ERROR_GETCFG_WLAN               = (0x80000000|301); // 获取无线网络信息失败
    public static final int NET_ERROR_GETCFG_WLANDEV            = (0x80000000|302); // 获取无线网络设备失败
    public static final int NET_ERROR_GETCFG_REGISTER           = (0x80000000|303); // 获取主动注册参数失败
    public static final int NET_ERROR_GETCFG_CAMERA             = (0x80000000|304); // 获取摄像头属性失败
    public static final int NET_ERROR_GETCFG_INFRARED           = (0x80000000|305); // 获取红外报警配置失败
    public static final int NET_ERROR_GETCFG_SOUNDALARM         = (0x80000000|306); // 获取音频报警配置失败
    public static final int NET_ERROR_GETCFG_STORAGE            = (0x80000000|307); // 获取存储位置配置失败
    public static final int NET_ERROR_GETCFG_MAIL               = (0x80000000|308); // 获取邮件配置失败
    public static final int NET_CONFIG_DEVBUSY                  = (0x80000000|309); // 暂时无法设置
    public static final int NET_CONFIG_DATAILLEGAL              = (0x80000000|310); // 配置数据不合法
    public static final int NET_ERROR_GETCFG_DST                = (0x80000000|311); // 获取夏令时配置失败
    public static final int NET_ERROR_SETCFG_DST                = (0x80000000|312); // 设置夏令时配置失败
    public static final int NET_ERROR_GETCFG_VIDEO_OSD          = (0x80000000|313); // 获取视频OSD叠加配置失败
    public static final int NET_ERROR_SETCFG_VIDEO_OSD          = (0x80000000|314); // 设置视频OSD叠加配置失败
    public static final int NET_ERROR_GETCFG_GPRSCDMA           = (0x80000000|315); // 获取CDMA\GPRS网络配置失败
    public static final int NET_ERROR_SETCFG_GPRSCDMA           = (0x80000000|316); // 设置CDMA\GPRS网络配置失败
    public static final int NET_ERROR_GETCFG_IPFILTER           = (0x80000000|317); // 获取IP过滤配置失败
    public static final int NET_ERROR_SETCFG_IPFILTER           = (0x80000000|318); // 设置IP过滤配置失败
    public static final int NET_ERROR_GETCFG_TALKENCODE         = (0x80000000|319); // 获取语音对讲编码配置失败
    public static final int NET_ERROR_SETCFG_TALKENCODE         = (0x80000000|320); // 设置语音对讲编码配置失败
    public static final int NET_ERROR_GETCFG_RECORDLEN          = (0x80000000|321); // 获取录像打包长度配置失败
    public static final int NET_ERROR_SETCFG_RECORDLEN          = (0x80000000|322); // 设置录像打包长度配置失败
    public static final int NET_DONT_SUPPORT_SUBAREA            = (0x80000000|323); // 不支持网络硬盘分区
    public static final int NET_ERROR_GET_AUTOREGSERVER         = (0x80000000|324); // 获取设备上主动注册服务器信息失败
    public static final int NET_ERROR_CONTROL_AUTOREGISTER      = (0x80000000|325); // 主动注册重定向注册错误
    public static final int NET_ERROR_DISCONNECT_AUTOREGISTER   = (0x80000000|326); // 断开主动注册服务器错误
    public static final int NET_ERROR_GETCFG_MMS                = (0x80000000|327); // 获取mms配置失败
    public static final int NET_ERROR_SETCFG_MMS                = (0x80000000|328); // 设置mms配置失败
    public static final int NET_ERROR_GETCFG_SMSACTIVATION      = (0x80000000|329); // 获取短信激活无线连接配置失败
    public static final int NET_ERROR_SETCFG_SMSACTIVATION      = (0x80000000|330); // 设置短信激活无线连接配置失败
    public static final int NET_ERROR_GETCFG_DIALINACTIVATION   = (0x80000000|331); // 获取拨号激活无线连接配置失败
    public static final int NET_ERROR_SETCFG_DIALINACTIVATION   = (0x80000000|332); // 设置拨号激活无线连接配置失败
    public static final int NET_ERROR_GETCFG_VIDEOOUT           = (0x80000000|333); // 查询视频输出参数配置失败
    public static final int NET_ERROR_SETCFG_VIDEOOUT           = (0x80000000|334); // 设置视频输出参数配置失败
    public static final int NET_ERROR_GETCFG_OSDENABLE          = (0x80000000|335); // 获取osd叠加使能配置失败
    public static final int NET_ERROR_SETCFG_OSDENABLE          = (0x80000000|336); // 设置osd叠加使能配置失败
    public static final int NET_ERROR_SETCFG_ENCODERINFO        = (0x80000000|337); // 设置数字通道前端编码接入配置失败
    public static final int NET_ERROR_GETCFG_TVADJUST           = (0x80000000|338); // 获取TV调节配置失败
    public static final int NET_ERROR_SETCFG_TVADJUST           = (0x80000000|339); // 设置TV调节配置失败
    public static final int NET_ERROR_CONNECT_FAILED            = (0x80000000|340); // 请求建立连接失败
    public static final int NET_ERROR_SETCFG_BURNFILE           = (0x80000000|341); // 请求刻录文件上传失败
    public static final int NET_ERROR_SNIFFER_GETCFG            = (0x80000000|342); // 获取抓包配置信息失败
    public static final int NET_ERROR_SNIFFER_SETCFG            = (0x80000000|343); // 设置抓包配置信息失败
    public static final int NET_ERROR_DOWNLOADRATE_GETCFG       = (0x80000000|344); // 查询下载限制信息失败
    public static final int NET_ERROR_DOWNLOADRATE_SETCFG       = (0x80000000|345); // 设置下载限制信息失败
    public static final int NET_ERROR_SEARCH_TRANSCOM           = (0x80000000|346); // 查询串口参数失败
    public static final int NET_ERROR_GETCFG_POINT              = (0x80000000|347); // 获取预制点信息错误
    public static final int NET_ERROR_SETCFG_POINT              = (0x80000000|348); // 设置预制点信息错误
    public static final int NET_SDK_LOGOUT_ERROR                = (0x80000000|349); // SDK没有正常登出设备
    public static final int NET_ERROR_GET_VEHICLE_CFG           = (0x80000000|350); // 获取车载配置失败
    public static final int NET_ERROR_SET_VEHICLE_CFG           = (0x80000000|351); // 设置车载配置失败
    public static final int NET_ERROR_GET_ATM_OVERLAY_CFG       = (0x80000000|352); // 获取atm叠加配置失败
    public static final int NET_ERROR_SET_ATM_OVERLAY_CFG       = (0x80000000|353); // 设置atm叠加配置失败
    public static final int NET_ERROR_GET_ATM_OVERLAY_ABILITY   = (0x80000000|354); // 获取atm叠加能力失败
    public static final int NET_ERROR_GET_DECODER_TOUR_CFG      = (0x80000000|355); // 获取解码器解码轮巡配置失败
    public static final int NET_ERROR_SET_DECODER_TOUR_CFG      = (0x80000000|356); // 设置解码器解码轮巡配置失败
    public static final int NET_ERROR_CTRL_DECODER_TOUR         = (0x80000000|357); // 控制解码器解码轮巡失败
    public static final int NET_GROUP_OVERSUPPORTNUM            = (0x80000000|358); // 超出设备支持最大用户组数目
    public static final int NET_USER_OVERSUPPORTNUM             = (0x80000000|359); // 超出设备支持最大用户数目
    public static final int NET_ERROR_GET_SIP_CFG               = (0x80000000|368); // 获取SIP配置失败
    public static final int NET_ERROR_SET_SIP_CFG               = (0x80000000|369); // 设置SIP配置失败
    public static final int NET_ERROR_GET_SIP_ABILITY           = (0x80000000|370); // 获取SIP能力失败
    public static final int NET_ERROR_GET_WIFI_AP_CFG           = (0x80000000|371); // 获取WIFI ap配置失败
    public static final int NET_ERROR_SET_WIFI_AP_CFG           = (0x80000000|372); // 设置WIFI ap配置失败
    public static final int NET_ERROR_GET_DECODE_POLICY         = (0x80000000|373); // 获取解码策略配置失败
    public static final int NET_ERROR_SET_DECODE_POLICY         = (0x80000000|374); // 设置解码策略配置失败
    public static final int NET_ERROR_TALK_REJECT               = (0x80000000|375); // 拒绝对讲
    public static final int NET_ERROR_TALK_OPENED               = (0x80000000|376); // 对讲被其他客户端打开
    public static final int NET_ERROR_TALK_RESOURCE_CONFLICIT   = (0x80000000|377); // 资源冲突
    public static final int NET_ERROR_TALK_UNSUPPORTED_ENCODE   = (0x80000000|378); // 不支持的语音编码格式
    public static final int NET_ERROR_TALK_RIGHTLESS            = (0x80000000|379); // 无权限
    public static final int NET_ERROR_TALK_FAILED               = (0x80000000|380); // 请求对讲失败
    public static final int NET_ERROR_GET_MACHINE_CFG           = (0x80000000|381); // 获取机器相关配置失败
    public static final int NET_ERROR_SET_MACHINE_CFG           = (0x80000000|382); // 设置机器相关配置失败
    public static final int NET_ERROR_GET_DATA_FAILED           = (0x80000000|383); // 设备无法获取当前请求数据
    public static final int NET_ERROR_MAC_VALIDATE_FAILED       = (0x80000000|384); // MAC地址验证失败
    public static final int NET_ERROR_GET_INSTANCE              = (0x80000000|385); // 获取服务器实例失败
    public static final int NET_ERROR_JSON_REQUEST              = (0x80000000|386); // 生成的json字符串错误
    public static final int NET_ERROR_JSON_RESPONSE             = (0x80000000|387); // 响应的json字符串错误
    public static final int NET_ERROR_VERSION_HIGHER            = (0x80000000|388); // 协议版本低于当前使用的版本
    public static final int NET_SPARE_NO_CAPACITY               = (0x80000000|389); // 设备操作失败, 容量不足
    public static final int NET_ERROR_SOURCE_IN_USE             = (0x80000000|390); // 显示源被其他输出占用
    public static final int NET_ERROR_REAVE                     = (0x80000000|391); // 高级用户抢占低级用户资源
    public static final int NET_ERROR_NETFORBID                 = (0x80000000|392); // 禁止入网
    public static final int NET_ERROR_GETCFG_MACFILTER          = (0x80000000|393); // 获取MAC过滤配置失败
    public static final int NET_ERROR_SETCFG_MACFILTER          = (0x80000000|394); // 设置MAC过滤配置失败
    public static final int NET_ERROR_GETCFG_IPMACFILTER        = (0x80000000|395); // 获取IP/MAC过滤配置失败
    public static final int NET_ERROR_SETCFG_IPMACFILTER        = (0x80000000|396); // 设置IP/MAC过滤配置失败
    public static final int NET_ERROR_OPERATION_OVERTIME        = (0x80000000|397); // 当前操作超时
    public static final int NET_ERROR_SENIOR_VALIDATE_FAILED    = (0x80000000|398); // 高级校验失败
    public static final int NET_ERROR_DEVICE_ID_NOT_EXIST       = (0x80000000|399); // 设备ID不存在
    public static final int NET_ERROR_UNSUPPORTED               = (0x80000000|400); // 不支持当前操作
    public static final int NET_ERROR_PROXY_DLLLOAD             = (0x80000000|401); // 代理库加载失败
    public static final int NET_ERROR_PROXY_ILLEGAL_PARAM       = (0x80000000|402); // 代理用户参数不合法
    public static final int NET_ERROR_PROXY_INVALID_HANDLE      = (0x80000000|403); // 代理句柄无效
    public static final int NET_ERROR_PROXY_LOGIN_DEVICE_ERROR 	= (0x80000000|404); // 代理登入前端设备失败
    public static final int NET_ERROR_PROXY_START_SERVER_ERROR  = (0x80000000|405); // 启动代理服务失败
    public static final int NET_ERROR_SPEAK_FAILED              = (0x80000000|406); // 请求喊话失败
    public static final int NET_ERROR_NOT_SUPPORT_F6            = (0x80000000|407); // 设备不支持此F6接口调用
    public static final int NET_ERROR_CD_UNREADY                = (0x80000000|408); // 光盘未就绪
    public static final int NET_ERROR_DIR_NOT_EXIST             = (0x80000000|409); // 目录不存在
    public static final int NET_ERROR_UNSUPPORTED_SPLIT_MODE    = (0x80000000|410); // 设备不支持的分割模式
    public static final int NET_ERROR_OPEN_WND_PARAM            = (0x80000000|411); // 开窗参数不合法
    public static final int NET_ERROR_LIMITED_WND_COUNT         = (0x80000000|412); // 开窗数量超过限制
    public static final int NET_ERROR_UNMATCHED_REQUEST         = (0x80000000|413); // 请求命令与当前模式不匹配
    public static final int NET_RENDER_ENABLELARGEPICADJUSTMENT_ERROR = (0x80000000|414); // Render库启用高清图像内部调整策略出错
    public static final int NET_ERROR_UPGRADE_FAILED            = (0x80000000|415); // 设备升级失败
    public static final int NET_ERROR_NO_TARGET_DEVICE          = (0x80000000|416); // 找不到目标设备
    public static final int NET_ERROR_NO_VERIFY_DEVICE          = (0x80000000|417); // 找不到验证设备
    public static final int NET_ERROR_CASCADE_RIGHTLESS         = (0x80000000|418); // 无级联权限
    public static final int NET_ERROR_LOW_PRIORITY              = (0x80000000|419); // 低优先级
    public static final int NET_ERROR_REMOTE_REQUEST_TIMEOUT    = (0x80000000|420); // 远程设备请求超时
    public static final int NET_ERROR_LIMITED_INPUT_SOURCE      = (0x80000000|421); // 输入源超出最大路数限制
    public static final int NET_ERROR_SET_LOG_PRINT_INFO        = (0x80000000|422); // 设置日志打印失败
    public static final int NET_ERROR_PARAM_DWSIZE_ERROR        = (0x80000000|423); // 入参的dwsize字段出错
    public static final int NET_ERROR_LIMITED_MONITORWALL_COUNT = (0x80000000|424); // 电视墙数量超过上限
    public static final int NET_ERROR_PART_PROCESS_FAILED       = (0x80000000|425); // 部分过程执行失败
    public static final int NET_ERROR_TARGET_NOT_SUPPORT        = (0x80000000|426); // 该功能不支持转发
    public static final int NET_ERROR_VISITE_FILE               = (0x80000000|510); // 访问文件失败
    public static final int NET_ERROR_DEVICE_STATUS_BUSY        = (0x80000000|511); // 设备忙
    public static final int NET_USER_PWD_NOT_AUTHORIZED         = (0x80000000|512); // 修改密码无权限
    public static final int NET_USER_PWD_NOT_STRONG             = (0x80000000|513); // 密码强度不够
    public static final int NET_ERROR_NO_SUCH_CONFIG            = (0x80000000|514); // 没有对应的配置
    public static final int NET_ERROR_AUDIO_RECORD_FAILED       = (0x80000000|515); // 录音失败
    public static final int NET_ERROR_SEND_DATA_FAILED          = (0x80000000|516); // 数据发送失败
    public static final int NET_ERROR_OBSOLESCENT_INTERFACE     = (0x80000000|517); // 废弃接口
    public static final int NET_ERROR_INSUFFICIENT_INTERAL_BUF  = (0x80000000|518); // 内部缓冲不足
    public static final int NET_ERROR_NEED_ENCRYPTION_PASSWORD  = (0x80000000|519); // 修改设备ip时,需要校验密码
    public static final int NET_ERROR_NOSUPPORT_RECORD          = (0x80000000|520); // 设备不支持此记录集
    public static final int NET_ERROR_SERIALIZE_ERROR           = (0x80000000|1010);// 数据序列化错误
    public static final int NET_ERROR_DESERIALIZE_ERROR         = (0x80000000|1011);// 数据反序列化错误
    public static final int NET_ERROR_LOWRATEWPAN_ID_EXISTED    = (0x80000000|1012);// 该无线ID已存在
    public static final int NET_ERROR_LOWRATEWPAN_ID_LIMIT      = (0x80000000|1013);// 无线ID数量已超限
    public static final int NET_ERROR_LOWRATEWPAN_ID_ABNORMAL   = (0x80000000|1014);// 无线异常添加
    public static final int NET_ERROR_ENCRYPT                   = (0x80000000|1015);// 加密数据失败
    public static final int NET_ERROR_PWD_ILLEGAL               = (0x80000000|1016);// 新密码不合规范
    public static final int NET_ERROR_DEVICE_ALREADY_INIT       = (0x80000000|1017);// 设备已经初始化
    public static final int NET_ERROR_SECURITY_CODE             = (0x80000000|1018);// 安全码错误
    public static final int NET_ERROR_SECURITY_CODE_TIMEOUT     = (0x80000000|1019);// 安全码超出有效期
    public static final int NET_ERROR_GET_PWD_SPECI             = (0x80000000|1020);// 获取密码规范失败
    public static final int NET_ERROR_NO_AUTHORITY_OF_OPERATION = (0x80000000|1021);// 无权限进行该操作
    public static final int NET_ERROR_DECRYPT                   = (0x80000000|1022);// 解密数据失败
    public static final int NET_ERROR_2D_CODE                   = (0x80000000|1023);// 2D code校验失败
    public static final int NET_ERROR_INVALID_REQUEST           = (0x80000000|1024);// 非法的RPC请求
    public static final int NET_ERROR_PWD_RESET_DISABLE			= (0x80000000|1025);// 密码重置功能已关闭
    public static final int NET_ERROR_PLAY_PRIVATE_DATA         = (0x80000000|1026);// 显示私有数据，比如规则框等失败
    public static final int NET_ERROR_ROBOT_OPERATE_FAILED      = (0x80000000|1027);// 机器人操作失败
    public static final int NET_ERROR_PHOTOSIZE_EXCEEDSLIMIT    = (0x80000000|1028);// 图片大小超限
    public static final int NET_ERROR_USERID_INVALID            = (0x80000000|1029);// 用户ID不存在
    public static final int NET_ERROR_EXTRACTFEATURE_FAILED     = (0x80000000|1030);// 照片特征值提取失败
    public static final int NET_ERROR_PHOTO_EXIST               = (0x80000000|1031);// 照片已存在
    public static final int NET_ERROR_PHOTO_OVERFLOW            = (0x80000000|1032);// 照片数量超过上限
    public static final int NET_ERROR_CHANNEL_ALREADY_OPENED	= (0x80000000|1033);// 通道已经打开
    public static final int NET_ERROR_CREATE_SOCKET				= (0x80000000|1034);// 创建套接字失败
    public static final int NET_ERROR_CHANNEL_NUM				= (0x80000000|1035);// 通道号错误
    public static final int NET_ERROR_PHOTO_FORMAT				= (0x80000000|1036);// 图片格式错误
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_INTERNAL_ERROR = (0x80000000|1037);	  // 内部错误(比如：相关硬件问题，获取公钥失败，内部接口调用失败，写文件失败等等)
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_GET_ID_FAILED	 = (0x80000000|1038);	  // 获取设备ID失败
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_IMPORT_ILLEGAL = (0x80000000|1039);	  // 证书文件非法(格式不支持或者不是证书文件)
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_SN_ERROR		 = (0x80000000|1040);	  // 证书sn重复或错误或不规范
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_COMMON_NAME_ILLEGAL = (0x80000000|1041);// 证书commonName非法(本地设备证书与系统中的不匹配devid_cryptoID,或者对端的不符合规则(devid_crytoID))
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_NO_ROOT_CERT	 = (0x80000000|1042); 	  // 根证书未导入或不存在
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_CERT_REVOKED	 = (0x80000000|1043);	  // 证书被吊销
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_CERT_INVALID	 = (0x80000000|1044);	  // 证书不可用或未生效或已过期
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_CERT_ERROR_SIGN = (0x80000000|1045);	  // 证书签名不匹配
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_COUNTS_UPPER_LIMIT = (0x80000000|1046); // 超出证书导入上限
    public static final int NET_ERROR_DIGITAL_CERTIFICATE_CERT_NO_EXIST	 = (0x80000000|1047);	  // 证书文件不存在(导出证书或者获取对应证书的公钥)
    public static final int NET_ERROR_FACE_RECOGNITION_SERVER_GROUP_ID_EXCEED = (0x80000000|1051);// 组ID超过最大值
    
    // CLIENT_StartListenEx报警事件
    public static final int NET_ALARM_ALARM_EX 					= 0x2101;     		// 外部报警，数据字节数与设备报警通道个数相同，每个字节表示一个报警通道的报警状态，1为有报警，0为无报警。
    public static final int NET_MOTION_ALARM_EX                	= 0x2102;          	// 动态检测报警，数据字节数与设备视频通道个数相同，每个字节表示一个视频通道的动态检测报警状态，1为有报警，0为无报警。
    public static final int NET_VIDEOLOST_ALARM_EX 				= 0x2103; 			// 视频丢失报警，数据字节数与设备视频通道个数相同，每个字节表示一个视频通道的视频丢失报警状态，1为有报警，0为无报警。
    public static final int NET_SHELTER_ALARM_EX 				= 0x2104;   		// 视频遮挡报警，数据字节数与设备视频通道个数相同，每个字节表示一个视频通道的遮挡(黑屏)报警状态，1为有报警，0为无报警。
    public static final int NET_DISKFULL_ALARM_EX 				= 0x2106;  			// 硬盘满报警，数据为1个字节，1为有硬盘满报警，0为无报警。
    public static final int NET_DISKERROR_ALARM_EX 				= 0x2107; 			// 坏硬盘报警，数据为32个字节，每个字节表示一个硬盘的故障报警状态，1为有报警，0为无报警。
    public static final int NET_ALARM_ACC_POWEROFF              = 0x211E;           // ACC断电报警，数据为 DWORD 0：ACC通电 1：ACC断电 
    public static final int NET_ALARM_FRONTDISCONNECT           = 0x2132;           // 前端IPC断网报警(对应结构体 ALARM_FRONTDISCONNET_INFO)
    public static final int NET_ALARM_BATTERYLOWPOWER 			= 0x2134;      		// 电池电量低报警(对应结构体 ALARM_BATTERYLOWPOWER_INFO)
    public static final int NET_ALARM_TEMPERATURE 				= 0x2135;  			// 温度过高报警(对应结构体 ALARM_TEMPERATURE_INFO)
    public static final int NET_ALARM_STORAGE_FAILURE_EX        = 0x2163;           // 存储错误报警(对应结构体 ALARM_STORAGE_FAILURE_EX)
    public static final int NET_ALARM_TALKING_INVITE            = 0x2171;           // 设备请求对方发起对讲事件(对应结构体  ALARM_TALKING_INVITE_INFO)
    public static final int NET_ALARM_ALARM_EX2 				= 0x2175;    		// 本地报警事件(对应结构体ALARM_ALARM_INFO_EX2,对NET_ALARM_ALARM_EX升级)
    public static final int NET_ALARM_IPC                       = 0x218c;           // IPC报警,IPC通过DVR或NVR上报的本地报警(对应结构体 ALARM_IPC_INFO)
    public static final int NET_EVENT_VIDEOABNORMALDETECTION    = 0x218e;           // 视频异常事件(对应ALARM_VIDEOABNORMAL_DETECTION_INFO)
    public static final int NET_ALARM_STORAGE_NOT_EXIST         = 0x3167;           // 存储组不存在事件(对应结构体 ALARM_STORAGE_NOT_EXIST_INFO)
    public static final int NET_ALARM_SCADA_DEV_ALARM           = 0x31a2;           // 检测采集设备报警事件(对应结构体 ALARM_SCADA_DEV_INFO)
    public static final int NET_ALARM_PARKING_CARD				= 0x31a4;			// 停车刷卡事件(对应结构体  ALARM_PARKING_CARD)
    public static final int NET_ALARM_VEHICLE_ACC               = 0x31a6;           // 车辆ACC报警事件(对应结构体 ALARM_VEHICLE_ACC_INFO)
    public static final int NET_ALARM_NEW_FILE                  = 0x31b3;           // 新文件事件(对应 ALARM_NEW_FILE_INFO)
    public static final int NET_ALARM_HUMAM_NUMBER_STATISTIC    = 0x31cc;           // 人数量/客流量统计事件 (对应结构体 ALARM_HUMAN_NUMBER_STATISTIC_INFO)
    public static final int NET_ALARM_ARMMODE_CHANGE_EVENT      = 0x3175;			// 布撤防状态变化事件(对应结构体 ALARM_ARMMODE_CHANGE_INFO)
    public static final int NET_ALARM_ACCESS_CTL_NOT_CLOSE      = 0x3177;           // 门禁未关事件(对应结构体 ALARM_ACCESS_CTL_NOT_CLOSE_INFO)
    public static final int NET_ALARM_ACCESS_CTL_BREAK_IN       = 0x3178;           // 闯入事件(对应结构体 ALARM_ACCESS_CTL_BREAK_IN_INFO)
    public static final int NET_ALARM_ACCESS_CTL_EVENT          = 0x3181;           // 门禁事件(对应结构体 ALARM_ACCESS_CTL_EVENT_INFO)
    public static final int NET_URGENCY_ALARM_EX2               = 0x3182;           // 紧急报警EX2(对 NET_URGENCY_ALARM_EX 的升级,对应结构体 ALARM_URGENCY_ALARM_EX2, 人为触发的紧急事件, 一般处理是联动外部通讯功能请求帮助
    public static final int NET_ALARM_ACCESS_CTL_STATUS         = 0x3185;           // 门禁状态事件(对应结构体 ALARM_ACCESS_CTL_STATUS_INFO)
    public static final int NET_ALARM_ALARMCLEAR                = 0x3187;           // 消警事件(对应结构体  ALARM_ALARMCLEAR_INFO )
    public static final int NET_ALARM_RCEMERGENCY_CALL          = 0x318b;  			// 紧急呼叫报警事件(对应结构体 ALARM_RCEMERGENCY_CALL_INFO)
    public static final int NET_ALARM_FINGER_PRINT              = 0x318d;           // 获取指纹事件(对应结构体 ALARM_CAPTURE_FINGER_PRINT_INFO)
    public static final int NET_ALARM_BUS_SHARP_ACCELERATE      = 0x31ae;           // 车辆急加速事件(对应结构体 ALARM_BUS_SHARP_ACCELERATE_INFO)
    public static final int NET_ALARM_BUS_SHARP_DECELERATE      = 0x31af;           // 车辆急减速事件(对应结构体 ALARM_BUS_SHARP_DECELERATE_INFO)
    public static final int NET_ALARM_ACCESS_CARD_OPERATE       = 0x31b0;           // 门禁卡数据操作事件(对应结构体ALARM_ACCESS_CARD_OPERATE_INFO)
    public static final int NET_ALARM_WIFI_SEARCH               = 0x31c7;           // 获取到周围环境中WIFI设备上报事件(对应结构体 ALARM_WIFI_SEARCH_INFO)
    public static final int NET_ALARM_HOTSPOT_WARNING           = 0X31d8;           // 热成像热点异常报警(对应结构体 ALARM_HOTSPOT_WARNING_INFO)
    public static final int NET_ALARM_COLDSPOT_WARNING          = 0X31d9;           // 热成像冷点异常报警(对应结构体 ALARM_COLDSPOT_WARNING_INFO)
    public static final int NET_ALARM_FIREWARNING_INFO          = 0X31da;           // 热成像火情报警信息上报(对应结构体 ALARM_FIREWARNING_INFO_DETAIL)
    public static final int NET_ALARM_RADAR_HIGH_SPEED          = 0x31df;           // 雷达监测超速报警事件 智能楼宇专用 (对应结构体 ALARM_RADAR_HIGH_SPEED_INFO)
    public static final int NET_ALARM_POLLING_ALARM             = 0x31e0;           // 设备巡检报警事件 智能楼宇专用 (对应结构体 ALARM_POLLING_ALARM_INFO)
    public static final int NET_ALARM_WIFI_VIRTUALINFO_SEARCH   = 0x31ef;           // WIFI虚拟身份上报事件(对应结构体 ALARM_WIFI_VIRTUALINFO_SEARCH_INFO)
    public static final int NET_ALARM_GPS_NOT_ALIGNED           = 0x321d;           // GPS未定位报警(对应结构体 ALARM_GPS_NOT_ALIGNED_INFO)
    public static final int NET_ALARM_VIDEOBLIND                = 0x323e;           // 视频遮挡事件(对应结构体 ALARM_VIDEO_BLIND_INFO)
    public static final int NET_ALARM_DRIVER_NOTCONFIRM         = 0x323f;           // 司机未按确认按钮报警事件(对应结构体 ALARM_DRIVER_NOTCONFIRM_INFO)
    public static final int NET_ALARM_FACEINFO_COLLECT          = 0x3240;           // 人脸信息录入事件(对应 ALARM_FACEINFO_COLLECT_INFO)
    public static final int NET_ALARM_HIGH_SPEED	            = 0x3241;			// 车辆超速报警事件(对应 ALARM_HIGH_SPEED_INFO )
    public static final int NET_ALARM_VIDEO_LOSS                = 0x3242;			// 视频丢失事件(对应 ALARM_VIDEO_LOSS_INFO )
    public static final int NET_ALARM_DOWNLOAD_REMOTE_FILE		= 0x3301;			// 下载远程文件事件(对应 ALARM_DOWNLOAD_REMOTE_FILE_INFO) 
    public static final int NET_ALARM_TRAFFIC_LINKAGEALARM		= 0x3353;			// 各种违章事件联动报警输出事件(对应结构体 ALARM_TRAFFIC_LINKAGEALARM_INFO)


    // 订阅Bus状态对应事件上报(CLIENT_AttachBusState)
    public static final int NET_ALARM_BUS_PASSENGER_CARD_CHECK  = 0x0009;           // 乘客刷卡事件(对应结构体 ALARM_PASSENGER_CARD_CHECK )
    
    // 帧类型掩码定义
    public static final int FRAME_TYPE_MOTION                   = 0x00000001;       // 动检帧
    
    // CLIENT_RealLoadPictureEx 智能抓图事件
    public static final int EVENT_IVS_ALL                       = 0x00000001;       // 订阅所有事件
    public static final int EVENT_IVS_CROSSLINEDETECTION        = 0x00000002;       // 警戒线事件(对应 DEV_EVENT_CROSSLINE_INFO)
    public static final int EVENT_IVS_CROSSREGIONDETECTION      = 0x00000003;       // 警戒区事件(对应 DEV_EVENT_CROSSREGION_INFO)
    public static final int EVENT_IVS_WANDERDETECTION           = 0x00000007;       // 徘徊事件(对应  DEV_EVENT_WANDER_INFO)
    public static final int EVENT_IVS_FIGHTDETECTION            = 0x0000000E;       // 斗殴事件(对应 DEV_EVENT_FIGHT_INFO)  
    public static final int EVENT_IVS_TRAFFICJUNCTION           = 0x00000017;       // 交通路口事件----老规则(对应 DEV_EVENT_TRAFFICJUNCTION_INFO)
    public static final int EVENT_IVS_TRAFFICGATE               = 0x00000018;       // 交通卡口事件----老规则(对应 DEV_EVENT_TRAFFICGATE_INFO)
    public static final int EVENT_IVS_FACEDETECT                = 0x0000001A;       // 人脸检测事件 (对应 DEV_EVENT_FACEDETECT_INFO)(智能规则对应  EVENT_IVS_FACEDETECT)
    public static final int EVENT_IVS_TRAFFICJAM                = 0x0000001B;       // 交通拥堵事件(对应 DEV_EVENT_TRAFFICJAM_INFO)
    public static final int EVENT_IVS_TRAFFIC_RUNREDLIGHT       = 0x00000100;       // 交通违章-闯红灯事件(对应 DEV_EVENT_TRAFFIC_RUNREDLIGHT_INFO)
    public static final int EVENT_IVS_TRAFFIC_OVERLINE          = 0x00000101;       // 交通违章-压车道线事件(对应 DEV_EVENT_TRAFFIC_OVERLINE_INFO)
    public static final int EVENT_IVS_TRAFFIC_RETROGRADE        = 0x00000102;       // 交通违章-逆行事件(对应  DEV_EVENT_TRAFFIC_RETROGRADE_INFO)
    public static final int EVENT_IVS_TRAFFIC_TURNLEFT          = 0x00000103;       // 交通违章-违章左转(对应 DEV_EVENT_TRAFFIC_TURNLEFT_INFO)
    public static final int EVENT_IVS_TRAFFIC_TURNRIGHT         = 0x00000104;       // 交通违章-违章右转(对应 DEV_EVENT_TRAFFIC_TURNRIGHT_INFO)
    public static final int EVENT_IVS_TRAFFIC_UTURN             = 0x00000105;       // 交通违章-违章掉头(对应 DEV_EVENT_TRAFFIC_UTURN_INFO)
    public static final int EVENT_IVS_TRAFFIC_OVERSPEED         = 0x00000106;       // 交通违章-超速(对应 DEV_EVENT_TRAFFIC_OVERSPEED_INFO)
    public static final int EVENT_IVS_TRAFFIC_UNDERSPEED        = 0x00000107;       // 交通违章-低速(对应 DEV_EVENT_TRAFFIC_UNDERSPEED_INFO)
    public static final int EVENT_IVS_TRAFFIC_PARKING           = 0x00000108;       // 交通违章-违章停车(对应 DEV_EVENT_TRAFFIC_PARKING_INFO)
    public static final int EVENT_IVS_TRAFFIC_WRONGROUTE        = 0x00000109;       // 交通违章-不按车道行驶(对应 DEV_EVENT_TRAFFIC_WRONGROUTE_INFO)
    public static final int EVENT_IVS_TRAFFIC_CROSSLANE         = 0x0000010A;       // 交通违章-违章变道(对应 DEV_EVENT_TRAFFIC_CROSSLANE_INFO)
    public static final int EVENT_IVS_TRAFFIC_OVERYELLOWLINE    = 0x0000010B;       // 交通违章-压黄线 (对应 DEV_EVENT_TRAFFIC_OVERYELLOWLINE_INFO)
    public static final int EVENT_IVS_TRAFFIC_YELLOWPLATEINLANE = 0x0000010E;       // 交通违章-黄牌车占道事件(对应 DEV_EVENT_TRAFFIC_YELLOWPLATEINLANE_INFO)
    public static final int EVENT_IVS_TRAFFIC_PEDESTRAINPRIORITY = 0x0000010F;      // 交通违章-斑马线行人优先事件(对应 DEV_EVENT_TRAFFIC_PEDESTRAINPRIORITY_INFO)
    public static final int EVENT_IVS_TRAFFIC_NOPASSING         = 0x00000111;       // 交通违章-禁止通行事件(对应 DEV_EVENT_TRAFFIC_NOPASSING_INFO)
    public static final int EVENT_IVS_FACERECOGNITION           = 0x00000117;       // 人脸识别事件(对应 DEV_EVENT_FACERECOGNITION_INFO, (对应的智能规则配置  CFG_FACERECOGNITION_INFO)
    public static final int EVENT_IVS_TRAFFIC_MANUALSNAP        = 0x00000118;       // 交通手动抓拍事件(对应  DEV_EENT_TRAFFIC_MANUALSNAP_INFO)
    public static final int EVENT_IVS_TRAFFIC_FLOWSTATE         = 0x00000119;       // 交通流量统计事件(对应 DEV_EVENT_TRAFFIC_FLOW_STATE)
    public static final int EVENT_IVS_TRAFFIC_VEHICLEINROUTE    = 0x0000011B;       // 有车占道事件(对应 DEV_EVENT_TRAFFIC_VEHICLEINROUTE_INFO)
    public static final int EVENT_IVS_TRAFFIC_TOLLGATE          = 0x00000120;       // 交通违章--卡口事件----新规则(对应 DEV_EVENT_TRAFFICJUNCTION_INFO)
    public static final int EVENT_IVS_TRAFFIC_VEHICLEINBUSROUTE = 0x00000124;       // 交通违章--占用公交车道事件(对应 DEV_EVENT_TRAFFIC_VEHICLEINBUSROUTE_INFO)
    public static final int EVENT_IVS_TRAFFIC_BACKING           = 0x00000125;       // 交通违章--违章倒车事件(对应 DEV_EVENT_IVS_TRAFFIC_BACKING_INFO)
    public static final int EVENT_IVS_AUDIO_ABNORMALDETECTION   = 0x00000126;       // 声音异常检测(对应 DEV_EVENT_IVS_AUDIO_ABNORMALDETECTION_INFO)
    public static final int EVENT_IVS_TRAFFIC_RUNYELLOWLIGHT    = 0x00000127;       // 交通违章-闯黄灯事件(对应 DEV_EVENT_TRAFFIC_RUNYELLOWLIGHT_INFO)
    public static final int EVENT_IVS_CLIMBDETECTION            = 0x00000128;       // 攀高检测事件(对应 DEV_EVENT_IVS_CLIMB_INFO)
    public static final int EVENT_IVS_LEAVEDETECTION            = 0x00000129;       // 离岗检测事件(对应 DEV_EVENT_IVS_LEAVE_INFO)
    public static final int EVENT_IVS_TRAFFIC_PARKINGONYELLOWBOX = 0x0000012A;      // 交通违章--黄网格线抓拍事件(对应 DEV_EVENT_TRAFFIC_PARKINGONYELLOWBOX_INFO)
    public static final int EVENT_IVS_TRAFFIC_PARKINGSPACEPARKING = 0x0000012B;     // 车位有车事件(对应 DEV_EVENT_TRAFFIC_PARKINGSPACEPARKING_INFO )
    public static final int EVENT_IVS_TRAFFIC_PARKINGSPACENOPARKING = 0x0000012C;   // 车位无车事件(对应  DEV_EVENT_TRAFFIC_PARKINGSPACENOPARKING_INFO )
    public static final int EVENT_IVS_TRAFFIC_PEDESTRAIN        = 0x0000012D;       // 交通行人事件(对应 DEV_EVENT_TRAFFIC_PEDESTRAIN_INFO)
    public static final int EVENT_IVS_TRAFFIC_THROW             = 0x0000012E;       // 交通抛洒物品事件(对应 DEV_EVENT_TRAFFIC_THROW_INFO)
    public static final int EVENT_IVS_TRAFFIC_OVERSTOPLINE      = 0X00000137;       // 交通违章--压停止线事件(对应 DEV_EVENT_TRAFFIC_OVERSTOPLINE)
    public static final int EVENT_IVS_TRAFFIC_WITHOUT_SAFEBELT  = 0x00000138;       // 交通违章--交通未系安全带事件(对应 DEV_EVENT_TRAFFIC_WITHOUT_SAFEBELT)
    public static final int EVENT_IVS_TRAFFIC_PASSNOTINORDER    = 0x0000013C;       // 交通违章--未按规定依次通行(对应 DEV_EVENT_TRAFFIC_PASSNOTINORDER_INFO)
    public static final int EVENT_IVS_TRAFFIC_JAM_FORBID_INTO	= 0x00000163;       // 交通违章--车辆拥堵禁入事件(对应 DEV_EVENT_ALARM_JAMFORBIDINTO_INFO)
    public static final int EVENT_IVS_TRAFFIC_FCC               = 0x0000016B;       // 加油站提枪、挂枪事件(对应  DEV_EVENT_TRAFFIC_FCC_INFO)
    public static final int EVENT_IVS_ACCESS_CTL                = 0x00000204;       // 门禁事件 (对应 DEV_EVENT_ACCESS_CTL_INFO)
    public static final int EVENT_IVS_SNAPMANUAL                = 0x00000205;       // SnapManual事件(对应 DEV_EVENT_SNAPMANUAL)
    public static final int EVENT_IVS_CITIZEN_PICTURE_COMPARE   = 0x00000209;       // 人证比对事件(对应  DEV_EVENT_CITIZEN_PICTURE_COMPARE_INFO )
    public static final int EVENT_IVS_HUMANTRAIT                = 0x00000215;       // 人体特征事件(对应 DEV_EVENT_HUMANTRAIT_INFO)
    public static final int EVENT_IVS_FACEANALYSIS              = 0x00000217;       // 人脸分析事件 (暂未有具体事件)
    public static final int EVENT_IVS_VEHICLE_RECOGNITION       = 0x00000231;       // 车牌对比事件(中石化智慧加油站项目)(对应 DEV_EVENT_VEHICLE_RECOGNITION_INFO)
    public static final int EVENT_IVSS_FACEATTRIBUTE            = 0x00000243;       // IVSS人脸检测事件 (暂未有具体事件)
    public static final int EVENT_IVSS_FACECOMPARE              = 0x00000244;       // IVSS人脸识别事件 (暂未有具体事件)
    
    // CLIENT_GetNewDevConfig / CLIENT_SetNewDevConfig 配置项
    public static final String CFG_CMD_VIDEOWIDGET              = "VideoWidget";         // 视频编码物件配置(对应 NET_CFG_VideoWidget )
    public static final String CFG_CMD_ANALYSEGLOBAL            = "VideoAnalyseGlobal";  // 视频分析全局配置(对应 CFG_ANALYSEGLOBAL_INFO)
    public static final String CFG_CMD_ANALYSEMODULE            = "VideoAnalyseModule";  // 物体的检测模块配置(对应 CFG_ANALYSEMODULES_INFO)
    public static final String CFG_CMD_ANALYSERULE              = "VideoAnalyseRule";    // 视频分析规则配置(对应 CFG_ANALYSERULES_INFO)
    public static final String CFG_CMD_VIDEOINOPTIONS           = "VideoInOptions";      // 视频输入前端选项(对应CFG_VIDEO_IN_OPTIONS)
    public static final String CFG_CMD_RAINBRUSHMODE            = "RainBrushMode";       // 雨刷模式相关配置(对应CFG_RAINBRUSHMODE_INFO数组)
    public static final String CFG_CMD_RAINBRUSH                = "RainBrush";           // 雨刷配置(对应CFG_RAINBRUSH_INFO)
    public static final String CFG_CMD_ENCODE                   = "Encode";              // 图像通道属性配置(对应CFG_ENCODE_INFO)
    public static final String CFG_CMD_VIDEO_IN_ZOOM            = "VideoInZoom";         // 云台通道变倍配置(对应CFG_VIDEO_IN_ZOOM)
    public static final String CFG_CMD_REMOTEDEVICE				= "RemoteDevice";		 // 远程设备信息(对应  AV_CFG_RemoteDevice 数组, 通道无关)
    public static final String CFG_CMD_ANALYSESOURCE			= "VideoAnalyseSource";  // 视频分析资源配置(对应 CFG_ANALYSESOURCE_INFO)
    public static final String CFG_CMD_TRAFFICGLOBAL            = "TrafficGlobal";       // 智能交通全局配置(CFG_TRAFFICGLOBAL_INFO)
    public static final String CFG_CMD_RECORDMODE               = "RecordMode";          // 录像模式(对应  AV_CFG_RecordMode )
    public static final String CFG_CMD_ALARMLAMP                = "AlarmLamp";           // 警灯配置(对应 CFG_ALARMLAMP_INFO)
    public static final String CFG_CMD_ALARMOUT                 = "AlarmOut";            // 报警输出通道配置(对应  CFG_ALARMOUT_INFO )
    public static final String CFG_CMD_INTELLECTIVETRAFFIC      = "TrafficSnapshot";     // 智能交通抓拍(对应 CFG_TRAFFICSNAPSHOT_INFO )
    public static final String CFG_CMD_TRAFFICSNAPSHOT_MULTI    = "TrafficSnapshotNew" ; // 智能交通抓拍( CFG_TRAFFICSNAPSHOT_NEW_INFO )
    public static final String CFG_CMD_NTP       				= "NTP";     			 // 时间同步服务器(对应  CFG_NTP_INFO )
    public static final String CFG_CMD_ALARMINPUT               = "Alarm";               // 外部输入报警配置(对应 CFG_ALARMIN_INFO)
    public static final String CFG_CMD_DVRIP                    = "DVRIP";               // 网络协议配置(对应 CFG_DVRIP_INFO)
    public static final String CFG_CMD_NETWORK                  = "Network";             // 网络配置(对应 CFG_NETWORK_INFO)
    public static final String CFG_CMD_MONITORWALL              = "MonitorWall";         // 电视墙配置(对应  AV_CFG_MonitorWall 数组, 通道无关)
    public static final String CFG_CMD_RTMP                  	= "RTMP";             	 // RTMP配置(对应  CFG_RTMP_INFO)
    public static final String CFG_CMD_ACCESS_EVENT             = "AccessControl";       // 门禁事件配置(对应 CFG_ACCESS_EVENT_INFO 数组)
    public static final String CFG_CMD_ACCESSTIMESCHEDULE       = "AccessTimeSchedule";  // 门禁刷卡时间段(对应 CFG_ACCESS_TIMESCHEDULE_INFO) 
    public static final String CFG_CMD_DEV_GENERRAL             = "General";             // 普通配置 (对应 CFG_DEV_DISPOSITION_INFO)
    public static final String CFG_CMD_VIDEODIAGNOSIS_PROFILE   = "VideoDiagnosisProfile";// 视频诊断参数表(CFG_VIDEODIAGNOSIS_PROFILE)
    public static final String CFG_CMD_VIDEODIAGNOSIS_TASK      = "VideoDiagnosisTask";   // 视频诊断任务表(CFG_VIDEODIAGNOSIS_TASK)
    public static final String CFG_CMD_VIDEODIAGNOSIS_TASK_ONE  = "VideoDiagnosisTask.x"; // 视频诊断任务表(CFG_VIDEODIAGNOSIS_TASK)
    public static final String CFG_CMD_VIDEODIAGNOSIS_PROJECT   = "VideoDiagnosisProject";// 视频诊断计划表(CFG_VIDEODIAGNOSIS_PROJECT)
    public static final String CFG_CMD_THERMO_GRAPHY			= "ThermographyOptions";  // 热成像摄像头属性配置(CFG_THERMOGRAPHY_INFO)
    public static final String CFG_CMD_THERMOMETRY_RULE         = "ThermometryRule";      // 热成像测温规则配置(对应 CFG_RADIOMETRY_RULE_INFO)
    public static final String CFG_CMD_TEMP_STATISTICS          = "TemperatureStatistics"; // 温度统计配置(CFG_TEMP_STATISTICS_INFO)
    public static final String CFG_CMD_THERMOMETRY              = "HeatImagingThermometry";// 热成像测温全局配置(CFG_THERMOMETRY_INFO)
    
    // CLIENT_FileTransmit接口传输文件类型
    public static final int NET_DEV_BLACKWHITETRANS_START      = 0x0003;           // 开始发送黑白名单(对应结构体 NETDEV_BLACKWHITE_LIST_INFO)
    public static final int NET_DEV_BLACKWHITETRANS_SEND       = 0x0004;           // 发送黑白名单
    public static final int NET_DEV_BLACKWHITETRANS_STOP       = 0x0005;           // 停止发送黑白名单
    
    // 配置类型,对应CLIENT_GetDevConfig和CLIENT_SetDevConfig接口
    public static final int NET_DEV_DEVICECFG                   = 0x0001;           // 设备属性配置
    public static final int NET_DEV_NETCFG_EX                   = 0x005b;           // 网络扩展配置(对应结构体 NETDEV_NET_CFG_EX )
    public static final int NET_DEV_TIMECFG                     = 0x0008;           // DVR时间配置

    // 命令类型, 对应 CLIENT_QueryNewSystemInfo 接口
    public static final String CFG_CAP_CMD_DEVICE_STATE         = "trafficSnap.getDeviceStatus";   // 获取设备状态信息 (对应 CFG_CAP_TRAFFIC_DEVICE_STATUS)
    public static final String CFG_CAP_CMD_RECORDFINDER         = "RecordFinder.getCaps";          // 获取查询记录能力集, (对应结构体 CFG_CAP_RECORDFINDER_INFO)
    public static final String CFG_CMD_VIDEODIAGNOSIS_GETSTATE  = "videoDiagnosisServer.getState"; // 获取视频诊断进行状态(CFG_VIDEODIAGNOSIS_STATE_INFO)
    
    // 远程配置结构体相关常量                 
    public static final int NET_MAX_MAIL_ADDR_LEN              = 128;              // 邮件发(收)地址最大长度
    public static final int NET_MAX_MAIL_SUBJECT_LEN           = 64;               // 邮件主题最大长度
    public static final int NET_MAX_IPADDR_LEN                 = 16;               // IP地址字符串长度
    public static final int NET_MAX_IPADDR_LEN_EX              = 40;               // 扩展IP地址字符串长度, 支持IPV6
    public static final int NET_USER_NAME_LEN_EX               = 32;               // 用户名长度,用于新平台扩展
    public static final int NET_USER_PSW_LEN_EX                = 32;               // 用户密码长度,用于新平台扩展
    
    public static final int NET_MAX_DEV_ID_LEN                 = 48;               // 机器编号最大长度
    public static final int NET_MAX_HOST_NAMELEN               = 64;               // 主机名长度,
    public static final int NET_MAX_HOST_PSWLEN                = 32;               // 密码长度
    public static final int NET_MAX_ETHERNET_NUM               = 2;                // 以太网口最大个数
    public static final int NET_MAX_ETHERNET_NUM_EX            = 10;               // 扩展以太网口最大个数
    public static final int NET_DEV_CLASS_LEN                  = 16;               // 设备类型字符串（如"IPC"）长度
    public static final int NET_N_WEEKS                        = 7;                // 一周的天数    
    public static final int NET_N_TSECT                        = 6;                // 通用时间段个数
    public static final int NET_N_REC_TSECT                    = 6;                // 录像时间段个数
    public static final int NET_N_COL_TSECT                    = 2;                // 颜色时间段个数            
    public static final int NET_N_ENCODE_AUX                   = 3;                // 扩展码流个数    
    public static final int NET_N_TALK                         = 1;                // 最多对讲通道个数
    public static final int NET_N_COVERS                       = 1;                // 遮挡区域个数    
    public static final int NET_N_CHANNEL                      = 16;               // 最大通道个数    
    public static final int NET_N_ALARM_TSECT                  = 2;                // 报警提示时间段个数
    public static final int NET_MAX_ALARMOUT_NUM               = 16;               // 报警输出口个数上限
    public static final int NET_MAX_AUDIO_IN_NUM               = 16;               // 音频输入口个数上限
    public static final int NET_MAX_VIDEO_IN_NUM               = 16;               // 视频输入口个数上限
    public static final int NET_MAX_ALARM_IN_NUM               = 16;               // 报警输入口个数上限
    public static final int NET_MAX_DISK_NUM                   = 16;               // 硬盘个数上限,暂定为16
    public static final int NET_MAX_DECODER_NUM                = 16;               // 解码器(485)个数上限    
    public static final int NET_MAX_232FUNCS                   = 10;               // 232串口功能个数上限
    public static final int NET_MAX_232_NUM                    = 2;                // 232串口个数上限
    public static final int NET_MAX_232_NUM_EX                 = 16;               // 扩展串口配置个数上限          
    public static final int NET_MAX_DECPRO_LIST_SIZE           = 100;              // 解码器协议列表个数上限
    public static final int NET_FTP_MAXDIRLEN                  = 240;              // FTP文件目录最大长度
    public static final int NET_MATRIX_MAXOUT                  = 16;               // 矩阵输出口最大个数
    public static final int NET_TOUR_GROUP_NUM                 = 6;                // 矩阵输出组最大个数
    public static final int NET_MAX_DDNS_NUM                   = 10;               // 设备支持的ddns服务器最大个数
    public static final int NET_MAX_SERVER_TYPE_LEN            = 32;               // ddns服务器类型,最大字符串长度
    public static final int NET_MAX_DOMAIN_NAME_LEN            = 256;              // ddns域名,最大字符串长度
    public static final int NET_MAX_DDNS_ALIAS_LEN             = 32;               // ddns服务器别名,最大字符串长度
    public static final int NET_MAX_DEFAULT_DOMAIN_LEN         = 60;               // ddns默认域名,最大字符串长度     
    public static final int NET_MOTION_ROW                     = 32;               // 动态检测区域的行数
    public static final int NET_MOTION_COL                     = 32;               // 动态检测区域的列数
    public static final int NET_STATIC_ROW                     = 32;               // 静态检测区域的行数
    public static final int NET_STATIC_COL                     = 32;               // 静态检测区域的列数
    public static final int NET_FTP_USERNAME_LEN               = 64;               // FTP配置,用户名最大长度
    public static final int NET_FTP_PASSWORD_LEN               = 64;               // FTP配置,密码最大长度
    public static final int NET_TIME_SECTION                   = 2;                // FTP配置,每天时间段个数
    public static final int NET_FTP_MAX_PATH                   = 240;              // FTP配置,文件路径名最大长度
    public static final int NET_FTP_MAX_SUB_PATH               = 128;              // FTP配置,文件路径名最大长度
    public static final int NET_INTERVIDEO_UCOM_CHANID         = 32;               // 平台接入配置,U网通通道ID
    public static final int NET_INTERVIDEO_UCOM_DEVID          = 32;               // 平台接入配置,U网通设备ID
    public static final int NET_INTERVIDEO_UCOM_REGPSW         = 16;               // 平台接入配置,U网通注册密码
    public static final int NET_INTERVIDEO_UCOM_USERNAME       = 32;               // 平台接入配置,U网通用户名
    public static final int NET_INTERVIDEO_UCOM_USERPSW        = 32;               // 平台接入配置,U网通密码
    public static final int NET_INTERVIDEO_NSS_IP              = 32;              // 平台接入配置,中兴力维IP
    public static final int NET_INTERVIDEO_NSS_SERIAL          = 32;               // 平台接入配置,中兴力维serial
    public static final int NET_INTERVIDEO_NSS_USER            = 32;               // 平台接入配置,中兴力维user
    public static final int NET_INTERVIDEO_NSS_PWD             = 50;              // 平台接入配置,中兴力维password
    public static final int NET_MAX_VIDEO_COVER_NUM            = 16;               // 遮挡区域最大个数
    public static final int NET_MAX_WATERMAKE_DATA             = 4096;             // 水印图片数据最大长度
    public static final int NET_MAX_WATERMAKE_LETTER           = 128;              // 水印文字最大长度
    public static final int NET_MAX_WLANDEVICE_NUM             = 10;               // 最多搜索出的无线设备个数
    public static final int NET_MAX_WLANDEVICE_NUM_EX          = 32;               // 最多搜索出的无线设备个数
    public static final int NET_MAX_ALARM_NAME                 = 64;               // 地址长度
    public static final int NET_MAX_REGISTER_SERVER_NUM        = 10;               // 主动注册服务器个数
    public static final int NET_SNIFFER_FRAMEID_NUM            = 6;                // 6个FRAME ID 选项
    public static final int NET_SNIFFER_CONTENT_NUM            = 4;                // 每个FRAME对应的4个抓包内容
    public static final int NET_SNIFFER_CONTENT_NUM_EX         = 8;                // 每个FRAME对应的8个抓包内容
    public static final int NET_SNIFFER_PROTOCOL_SIZE          = 20;               // 协议名字长度
    public static final int NET_MAX_PROTOCOL_NAME_LENGTH       = 20;               
    public static final int NET_SNIFFER_GROUP_NUM              = 4;                // 4组抓包设置
    public static final int NET_ALARM_OCCUR_TIME_LEN           = 40;               // 新的报警上传时间的长度
    public static final int NET_VIDEO_OSD_NAME_NUM             = 64;               // 叠加的名称长度,目前支持32个英文,16个中文
    public static final int NET_VIDEO_CUSTOM_OSD_NUM           = 8;               // 支持的自定义叠加的数目,不包含时间和通道
    public static final int NET_VIDEO_CUSTOM_OSD_NUM_EX        = 256;              // 支持的自定义叠加的数目,不包含时间和通道
    public static final int NET_CONTROL_AUTO_REGISTER_NUM      = 100;              // 支持定向主动注册服务器的个数
    public static final int NET_MMS_RECEIVER_NUM               = 100;              // 支持短信接收者的个数
    public static final int NET_MMS_SMSACTIVATION_NUM          = 100;              // 支持短信发送者的个数
    public static final int NET_MMS_DIALINACTIVATION_NUM       = 100;              // 支持拨号发送者的个数
    public static final int NET_MAX_ALARM_IN_NUM_EX            = 32;               // 报警输入口个数上限
    public static final int NET_MAX_IPADDR_OR_DOMAIN_LEN       = 64;               // IP地址字符串长度
    public static final int NET_MAX_CALLID                     = 32;               // 呼叫ID
    public static final int NET_MAX_FENCE_LINE_NUM             = 2;                // 围栏最大曲线数
    public static final int MAX_SMART_VALUE_NUM                = 30;               // 最多的smart信息个数
    public static final int NET_INTERVIDEO_AMP_DEVICESERIAL    = 48;               // 平台接入配置,天地阳光 设备序列号字符串长度
    public static final int NET_INTERVIDEO_AMP_DEVICENAME      = 16;               // 平台接入配置,天地阳光 设备名称字符串长度
    public static final int NET_INTERVIDEO_AMP_USER            = 32;               // 平台接入配置,天地阳光 注册用户名字符串长度
    public static final int NET_INTERVIDEO_AMP_PWD             = 32;               // 平台接入配置,天地阳光 注册密码字符串长度
    public static final int MAX_SUBMODULE_NUM                  = 32;               // 最多子模块信息个数
    public static final int NET_MAX_CARWAY_NUM                 = 8;                // 交通抓拍,最大车道数
    public static final int NET_MAX_SNAP_SIGNAL_NUM            = 3;                // 一个车道的最大抓拍张数
    public static final int NET_MAX_CARD_NUM                   = 128;              // 卡号的最大个数
    public static final int NET_MAX_CARDINFO_LEN               = 32;               // 每条卡号最长字符数
    public static final int NET_MAX_CONTROLER_NUM              = 64;               // 最大支持控制器数目
    public static final int NET_MAX_LIGHT_NUM                  = 32;               // 最多控制灯组数
    public static final int NET_MAX_SNMP_COMMON_LEN            = 64;               // snmp 读写数据长度
    public static final int NET_MAX_DDNS_STATE_LEN             = 128;              // DDNS 状态信息长度
    public static final int NET_MAX_PHONE_NO_LEN               = 16;               // 电话号码长度
    public static final int NET_MAX_MSGTYPE_LEN                = 32;               // 导航类型或短信息类型长度
    public static final int NET_MAX_MSG_LEN                    = 256;              // 导航和短信息长度
    public static final int NET_MAX_GRAB_INTERVAL_NUM          = 4;                // 多张图片抓拍个数
    public static final int NET_MAX_FLASH_NUM                  = 5;                // 最多支持闪光灯个数
    public static final int NET_MAX_ISCSI_PATH_NUM             = 64;               // ISCSI远程目录最大数量
    public static final int NET_MAX_WIRELESS_CHN_NUM           = 256;              // 无线路由最大信道数
    public static final int NET_PROTOCOL3_BASE                 = 100;              // 三代协议版本基数
    public static final int NET_PROTOCOL3_SUPPORT              = 11;               // 只支持3代协议
    public static final int NET_MAX_STAFF_NUM                  = 20;               // 浓缩视频配置信息中标尺数上限
    public static final int NET_MAX_CALIBRATEBOX_NUM           = 10;               // 浓缩视频配置信息中标定区域数上限
    public static final int NET_MAX_EXCLUDEREGION_NUM          = 10;               // 浓缩视频配置信息中排除区域数上限
    public static final int NET_MAX_POLYLINE_NUM               = 20;               // 浓缩视频配置信息中标尺线数
    public static final int NET_MAX_COLOR_NUM                  = 16;               // 最大颜色数目
    public static final int MAX_OBJFILTER_NUM                  = 16;               // 最大过滤种类个数
    public static final int NET_MAX_SYNOPSIS_STATE_NAME        = 64;               // 视频浓缩状态字符串长度
    public static final int NET_MAX_SYNOPSIS_QUERY_FILE_COUNT  = 10;               // 视频浓缩相关原始文件按照路径查找时文件个数上限
    public static final int NET_MAX_SSID_LEN                   = 36;               // SSID长度
    public static final int NET_MAX_APPIN_LEN                  = 16;               // PIN码长度
    public static final int NET_NETINTERFACE_NAME_LEN          = 260;              // 网口名称长度
    public static final int NET_NETINTERFACE_TYPE_LEN          = 260;              // 网络类型长度
    public static final int NET_MAX_CONNECT_STATUS_LEN         = 260;              // 连接状态字符串长度
    public static final int NET_MAX_MODE_LEN                   = 64;               // 3G支持的网络模式长度
    public static final int NET_MAX_MODE_NUM                   = 64;               // 3G支持的网络模式个数
    public static final int NET_MAX_COMPRESSION_TYPES_NUM      = 16;               // 视频编码格式最多种类个数
    public static final int NET_MAX_CAPTURE_SIZE_NUM           = 64;               // 视频分辨率个数
    public static final int NET_NODE_NAME_LEN                  = 64;               // 组织结构节点名称长度
    public static final int MAX_CALIBPOINTS_NUM                = 256;              // 支持最大标定点数
    public static final int NET_MAX_ATTR_NUM                   = 32;               // 显示单元属性最大数量
    public static final int NET_MAX_CLOUDCONNECT_STATE_LEN     = 128;              // 云注册连接状态信息长度
    public static final int NET_MAX_IPADDR_EX_LEN              = 128;              // 扩展IP地址最大长度
    public static final int MAX_EVENT_NAME                     = 128;              // 最长事件名
    public static final int NET_MAX_ETH_NAME                   = 64;               // 最大网卡名
    public static final int NET_N_SCHEDULE_TSECT               = 8;                // 时间表元素个数    
    public static final int NET_MAX_URL_NUM                    = 8;                // URL最大个数
    public static final int NET_MAX_LOWER_MITRIX_NUM           = 16;               // 最大下位矩阵数
    public static final int NET_MAX_BURN_CHANNEL_NUM           = 32;               // 最大刻录通道数
    public static final int NET_MAX_NET_STRORAGE_BLOCK_NUM     = 64;               // 最大远程存储区块数量
    public static final int NET_MAX_CASE_PERSON_NUM            = 32;               // 案件人员最大数量
    public static final int NET_MAX_MULTIPLAYBACK_CHANNEL_NUM  = 64;               // 最大多通道预览回放通道数
    public static final int NET_MAX_MULTIPLAYBACK_SPLIT_NUM    = 32;               // 最大多通道预览回放分割模式数
    public static final int NET_MAX_AUDIO_ENCODE_TYPE          = 64;               // 最大语音编码类型个数
    public static final int MAX_CARD_RECORD_FIELD_NUM          = 16;               // 卡号录像最大域数量
    public static final int NET_BATTERY_NUM_MAX                = 16;               // 最大电池数量    
    public static final int NET_POWER_NUM_MAX                  = 16;               // 最大电源数量        
    public static final int NET_MAX_AUDIO_PATH                 = 260;              // 最大音频文件路长度
    public static final int NET_MAX_DOORNAME_LEN               = 128;              // 最大门禁名称长度    
    public static final int NET_MAX_CARDPWD_LEN                = 64;               // 最大门禁名称长度    
    public static final int NET_MAX_FISHEYE_MOUNTMODE_NUM      = 4;                // 最大鱼眼安装模式个数
    public static final int NET_MAX_FISHEYE_CALIBRATEMODE_NUM  = 16;               // 最大鱼眼矫正模式个数
    public static final int NET_MAX_FISHEYE_EPTZCMD_NUM        = 64;               // 最大鱼眼电子云台操作个数   
    public static final int POINT_NUM_IN_PAIR                  = 2;                // 标定点对中的点数量
    public static final int MAX_POINT_PAIR_NUM                 = 128;              // 标定点最大数量
    public static final int CHANNEL_NUM_IN_POINT_GROUP         = 2;                // 标定点中的视频通道数
    public static final int MAX_POINT_GROUP_NUM                = 32;               // 标定点组最大数量, 每两个通道进行拼接需要一组标定点
    public static final int MAX_LANE_INFO_NUM                  = 32;               // 最大车道信息数
    public static final int MAX_LANE_DIRECTION_NUM             = 8;                // 车道方向总数
    public static final int NET_MAX_MONITORWALL_NUM            = 32;               // 电视墙最大数量
    public static final int NET_MAX_OPTIONAL_URL_NUM           = 8;                // 备用url最大数量
    public static final int NET_MAX_CAMERA_CHANNEL_NUM         = 1024;             // 最大摄像机通道数
    public static final int MAX_FILE_SUMMARY_NUM               = 32;               // 最大文件摘要数
    public static final int MAX_AUDIO_ENCODE_NUM               = 64;               // 最大支持音频编码个数

    public static final int MAX_FLASH_LIGHT_NUM                = 8;                // 最大支持的爆闪灯(闪光灯)个数
    public static final int MAX_STROBOSCOPIC_LIGHT_NUM         = 8;                // 最大支持的频闪灯个数
    public static final int MAX_MOSAIC_NUM					   = 8;				   // 最大支持的马赛克数量
    public static final int MAX_MOSAIC_CHANNEL_NUM			   = 256;			   // 支持马赛克叠加的最多通道数量
    public static final int MAX_FIREWARNING_INFO_NUM           = 4;                // 最大热成像着火点报警信息个数
    public static final int MAX_AXLE_NUM                       = 8;                // 最大车轴数量
    public static final int MAX_ACCESSDOOR_NUM                 = 128;              // 最大门数量 
    public static final int MAX_SIMILARITY_COUNT			   = 1024;			   // 最大人脸对比库阈值个数
    public static final int MAX_FEATURESTATE_NUM		       = 4;				   // 最大人脸组建模状态个数

    public static final int NET_MAX_BULLET_HOLES               = 10;               // 最大的弹孔数       

    public static final int MAX_NTP_SERVER                     = 4;                // 最大备用NTP服务器地址
    public static final int MAX_PLATE_NUM                      = 64;               // 每张图片中包含的最大车牌个数
    public static final int MAX_PREVIEW_CHANNEL_NUM            = 64;               // 最大导播预览的通道数量 
    public static final int MAX_ADDRESS_LEN                    = 256;              // 最大的地址长度
    public static final int MAX_DNS_SERVER_NUM                 = 2;                // DNS最大数量
    public static final int MAX_NETWORK_INTERFACE_NUM          = 32;               // 最大网卡数量

    public static final int MAX_EVENT_RESTORE_UUID			   = 36;			   // 事件重传uuid数组大小
    public static final int MAX_EVENT_RESTORE_CODE_NUM         = 8;			       // 最大事件重传类型个数
    public static final int MAX_EVENT_RESOTER_CODE_TYPE	       = 32;			   // 事件重传类型数组大小
    public static final int MAX_SNAP_TYPE                      = 3;                // 抓图类型数量
    public static final int MAX_MAINFORMAT_NUM                 = 4;                // 最大支持主码流类型数量

    public static final int CUSTOM_TITLE_LEN				   = 1024;			   // 自定义标题名称长度(扩充到1024)
    public static final int MAX_CUSTOM_TITLE_NUM    		   = 8;                // 编码物件自定义标题最大数量
    public static final int FORMAT_TYPE_LEN					   = 16;			   // 编码类型名最大长度

    public static final int MAX_CHANNEL_NAME_LEN			   = 256;     		   // 通道名称最大长度

    public static final int MAX_VIRTUALINFO_DOMAIN_LEN		   = 64;			   // 虚拟身份上网域名长度
    public static final int MAX_VIRTUALINFO_TITLE_LEN		   = 64;			   // 虚拟身份上网标题长度
    public static final int MAX_VIRTUALINFO_USERNAME_LEN	   = 32;			   // 虚拟身份用户名长度
    public static final int MAX_VIRTUALINFO_PASSWORD_LEN	   = 32;			   // 虚拟身份密码长度
    public static final int MAX_VIRTUALINFO_PHONENUM_LEN	   = 12;			   // 虚拟身份手机号长度
    public static final int MAX_VIRTUALINFO_IMEI_LEN	       = 16;			   // 虚拟身份国际移动设备标识长度
    public static final int MAX_VIRTUALINFO_IMSI_LEN	       = 16;			   // 虚拟身份国际移动用户识别码长度
    public static final int MAX_VIRTUALINFO_LATITUDE_LEN	   = 16;			   // 虚拟身份经度长度
    public static final int MAX_VIRTUALINFO_LONGITUDE_LEN	   = 16;			   // 虚拟身份纬度长度
    public static final int MAX_VIRTUALINFO_NUM				   = 1024;             // 最大虚拟身份信息个数
    public static final int MAX_SCREENTIME_COUNT			   = 8;				   // 诱导屏最大开关屏时间个数
	public static final int MAX_PLAYDATES_COUNT				   = 32;			   // 最大日期个数
	public static final int MAX_ELEMENTS_COUNT				   = 8;				   // 诱导屏窗口支持的最大元素个数
	public static final int MAX_ELEMENTTEXT_LENGTH			   = 512;			   // 文本元素最大文本长度
	public static final int MAX_NOTE_COUNT					   = 4;				   // 诱导屏窗口元素注释信息最大个数
	public static final int MAX_PROGRAMMES_COUNT			   = 32;			   // 最多支持的节目个数
    public static final int MAX_CALL_ID_LEN					   = 64;			   // 呼叫ID长度
    public static final int MAX_GD_COUNT					   = 170;
    public static final int MAX_SUNTIME_COUNT				   = 12;    		   // 日出日落时间个数
    public static final int MAX_DOOR_TIME_SECTION			   = 4;				   // 门禁每天分时时间段最大个数
    
    public static final int MAX_REMOTEDEVICEINFO_IPADDR_LEN    = 128;      		   // 远程设备IP地址最大长度
    public static final int MAX_REMOTEDEVICEINFO_USERNAME_LEN  = 128;              // 远程设备用户名最大长度
    public static final int MAX_REMOTEDEVICEINFO_USERPSW_LENGTH = 128;             // 远程设备密码最大长度
    
    public static final int MAX_MANUFACTURER_LEN               = 32;               // 最大的 MAC地址所属制造商长度
    public static final int MAX_MACHISTORY_SSID_LEN            = 24;               // 最大的历史SSID长度
    public static final int MAX_MACHISTORY_SSID_NUM	           = 5;	               // 历史SSID的最大个数
    
    public static final int CFG_MAX_SN_LEN					   = 32;			   // 最大设备序列号长度
    public static final int CFG_MAX_ACCESS_CONTROL_ADDRESS_LEN = 64;			   // 最大的地址长度
    
    public static final int MAX_MACADDR_NUM					   = 8;				   // 最大物理地址个数
    public static final int MAX_ADD_DEVICE_NUM                 = 16;               // 最大添加设备个数
    public static final int MAX_LINK_DEVICE_NUM                = 1024;             // 最大连接设备个数
    public static final int MAX_DEVICE_CHANNEL_NUM             = 1024;             // 设备最大通道个数
    public static final int NET_CFG_MAX_CTRLTYPE_NUM     	   = 16;               // 最大道闸控制方式
    public static final int NET_MAX_ALL_SNAP_CAR_COUNT	  	   = 32;			   // 所有车开闸种类个数
    public static final int NET_MAX_BURNING_DEV_NUM			   = 32;			   // 最大刻录设备个数
    public static final int NET_BURNING_DEV_NAMELEN			   = 32;			   // 刻录设备名字最大长度
    public static final int PTZ_PRESET_NAME_LEN				   = 64;			   // 云台预置点名称长度
    public static final int NET_RADIOMETRY_DOFIND_MAX		   = 32;			   // 热成像温度统计最大个数
    
    // 查询类型,对应CLIENT_QueryDevState接口
    public static final int NET_DEVSTATE_COMM_ALARM            = 0x0001;           // 查询普通报警状态(包括外部报警,视频丢失,动态检测)
    public static final int NET_DEVSTATE_SHELTER_ALARM         = 0x0002;           // 查询遮挡报警状态
    public static final int NET_DEVSTATE_RECORDING             = 0x0003;           // 查询录象状态
    public static final int NET_DEVSTATE_DISK                  = 0x0004;           // 查询硬盘信息
    public static final int NET_DEVSTATE_RESOURCE              = 0x0005;           // 查询系统资源状态
    public static final int NET_DEVSTATE_BITRATE               = 0x0006;           // 查询通道码流
    public static final int NET_DEVSTATE_CONN                  = 0x0007;           // 查询设备连接状态
    public static final int NET_DEVSTATE_PROTOCAL_VER          = 0x0008;           // 查询网络协议版本号,pBuf = int*
    public static final int NET_DEVSTATE_TALK_ECTYPE           = 0x0009;           // 查询设备支持的语音对讲格式列表,见结构体NETDEV_TALKFORMAT_LIST
    public static final int NET_DEVSTATE_SD_CARD               = 0x000A;           // 查询SD卡信息(IPC类产品)
    public static final int NET_DEVSTATE_BURNING_DEV           = 0x000B;           // 查询刻录机信息,见结构体NET_BURNING_DEVINFO
    public static final int NET_DEVSTATE_BURNING_PROGRESS      = 0x000C;           // 查询刻录进度
    public static final int NET_DEVSTATE_PLATFORM              = 0x000D;           // 查询设备支持的接入平台
    public static final int NET_DEVSTATE_CAMERA                = 0x000E;           // 查询摄像头属性信息(IPC类产品),pBuf = NETDEV_CAMERA_INFO *,可以有多个结构体
    public static final int NET_DEVSTATE_SOFTWARE              = 0x000F;           // 查询设备软件版本信息  NETDEV_VERSION_INFO
    public static final int NET_DEVSTATE_LANGUAGE              = 0x0010;           // 查询设备支持的语音种类
    public static final int NET_DEVSTATE_DSP                   = 0x0011;           // 查询DSP能力描述(对应结构体NET_DEV_DSP_ENCODECAP)
    public static final int NET_DEVSTATE_OEM                   = 0x0012;           // 查询OEM信息
    public static final int NET_DEVSTATE_NET                   = 0x0013;           // 查询网络运行状态信息
    public static final int NET_DEVSTATE_TYPE                  = 0x0014;           // 查询设备类型
    public static final int NET_DEVSTATE_SNAP                  = 0x0015;           // 查询功能属性(IPC类产品)
    public static final int NET_DEVSTATE_RECORD_TIME           = 0x0016;           // 查询最早录像时间和最近录像时间
    public static final int NET_DEVSTATE_NET_RSSI              = 0x0017;           // 查询无线网络信号强度,见结构体NETDEV_WIRELESS_RSS_INFO
    public static final int NET_DEVSTATE_BURNING_ATTACH        = 0x0018;           // 查询附件刻录选项
    public static final int NET_DEVSTATE_BACKUP_DEV            = 0x0019;           // 查询备份设备列表
    public static final int NET_DEVSTATE_BACKUP_DEV_INFO       = 0x001a;           // 查询备份设备详细信息 NETDEV_BACKUP_INFO
    public static final int NET_DEVSTATE_BACKUP_FEEDBACK       = 0x001b;           // 备份进度反馈
    public static final int NET_DEVSTATE_ATM_QUERY_TRADE       = 0x001c;           // 查询ATM交易类型
    public static final int NET_DEVSTATE_SIP                   = 0x001d;           // 查询sip状态
    public static final int NET_DEVSTATE_VICHILE_STATE         = 0x001e;           // 查询车载wifi状态
    public static final int NET_DEVSTATE_TEST_EMAIL            = 0x001f;           // 查询邮件配置是否成功
    public static final int NET_DEVSTATE_SMART_HARD_DISK       = 0x0020;           // 查询硬盘smart信息
    public static final int NET_DEVSTATE_TEST_SNAPPICTURE      = 0x0021;           // 查询抓图设置是否成功
    public static final int NET_DEVSTATE_STATIC_ALARM          = 0x0022;           // 查询静态报警状态
    public static final int NET_DEVSTATE_SUBMODULE_INFO        = 0x0023;           // 查询设备子模块信息
    public static final int NET_DEVSTATE_DISKDAMAGE            = 0x0024;           // 查询硬盘坏道能力 
    public static final int NET_DEVSTATE_IPC                   = 0x0025;           // 查询设备支持的IPC能力, 见结构体NET_DEV_IPC_INFO
    public static final int NET_DEVSTATE_ALARM_ARM_DISARM      = 0x0026;           // 查询报警布撤防状态
    public static final int NET_DEVSTATE_ACC_POWEROFF_ALARM    = 0x0027;           // 查询ACC断电报警状态(返回一个DWORD, 1表示断电,0表示通电)
    public static final int NET_DEVSTATE_TEST_FTP_SERVER       = 0x0028;           // 测试FTP服务器连接
    public static final int NET_DEVSTATE_3GFLOW_EXCEED         = 0x0029;           // 查询3G流量超出阈值状态,(见结构体 NETDEV_3GFLOW_EXCEED_STATE_INFO)
    public static final int NET_DEVSTATE_3GFLOW_INFO           = 0x002a;           // 查询3G网络流量信息,见结构体 NET_DEV_3GFLOW_INFO
    public static final int NET_DEVSTATE_VIHICLE_INFO_UPLOAD   = 0x002b;           // 车载自定义信息上传(见结构体 ALARM_VEHICLE_INFO_UPLOAD)
    public static final int NET_DEVSTATE_SPEED_LIMIT           = 0x002c;           // 查询限速报警状态(见结构体ALARM_SPEED_LIMIT)
    public static final int NET_DEVSTATE_DSP_EX                = 0x002d;           // 查询DSP扩展能力描述(对应结构体 NET_DEV_DSP_ENCODECAP_EX)
    public static final int NET_DEVSTATE_3GMODULE_INFO         = 0x002e;           // 查询3G模块信息(对应结构体NET_DEV_3GMODULE_INFO)
    public static final int NET_DEVSTATE_MULTI_DDNS            = 0x002f;           // 查询多DDNS状态信息(对应结构体NET_DEV_MULTI_DDNS_INFO)
    public static final int NET_DEVSTATE_CONFIG_URL            = 0x0030;           // 查询设备配置URL信息(对应结构体NET_DEV_URL_INFO)
    public static final int NET_DEVSTATE_HARDKEY               = 0x0031;           // 查询HardKey状态（对应结构体NETDEV_HARDKEY_STATE)
    public static final int NET_DEVSTATE_ISCSI_PATH            = 0x0032;           // 查询ISCSI路径列表(对应结构体NETDEV_ISCSI_PATHLIST)
    public static final int NET_DEVSTATE_DLPREVIEW_SLIPT_CAP   = 0x0033;           // 查询设备本地预览支持的分割模式(对应结构体DEVICE_LOCALPREVIEW_SLIPT_CAP)
    public static final int NET_DEVSTATE_WIFI_ROUTE_CAP        = 0x0034;           // 查询无线路由能力信息(对应结构体NETDEV_WIFI_ROUTE_CAP)
    public static final int NET_DEVSTATE_ONLINE                = 0x0035;           // 查询设备的在线状态(返回一个DWORD, 1表示在线, 0表示断线)
    public static final int NET_DEVSTATE_PTZ_LOCATION          = 0x0036;           // 查询云台状态信息(对应结构体 NET_PTZ_LOCATION_INFO)
    public static final int NET_DEVSTATE_MONITOR_INFO          = 0x0037;           // 画面监控辅助信息(对应结构体NETDEV_MONITOR_INFO)
    public static final int NET_DEVSTATE_SUBDEVICE             = 0x0300;           // 查询子设备(电源, 风扇等)状态(对应结构体CFG_DEVICESTATUS_INFO)
    public static final int NET_DEVSTATE_RAID_INFO             = 0x0038;           // 查询RAID状态(对应结构体ALARM_RAID_INFO)  
    public static final int NET_DEVSTATE_TEST_DDNSDOMAIN       = 0x0039;           // 测试DDNS域名是否可用
    public static final int NET_DEVSTATE_VIRTUALCAMERA         = 0x003a;           // 查询虚拟摄像头状态(对应 NETDEV_VIRTUALCAMERA_STATE_INFO)
    public static final int NET_DEVSTATE_TRAFFICWORKSTATE      = 0x003b;           // 获取设备工作视频/线圈模式状态等(对应NETDEV_TRAFFICWORKSTATE_INFO)
    public static final int NET_DEVSTATE_ALARM_CAMERA_MOVE     = 0x003c;           // 获取摄像机移位报警事件状态(对应ALARM_CAMERA_MOVE_INFO)
    public static final int NET_DEVSTATE_ALARM                 = 0x003e;           // 获取外部报警状态(对应 NET_CLIENT_ALARM_STATE) 
    public static final int NET_DEVSTATE_VIDEOLOST             = 0x003f;           // 获取视频丢失报警状态(对应 NET_CLIENT_VIDEOLOST_STATE) 
    public static final int NET_DEVSTATE_MOTIONDETECT          = 0x0040;           // 获取动态监测报警状态(对应 NET_CLIENT_MOTIONDETECT_STATE)
    public static final int NET_DEVSTATE_DETAILEDMOTION        = 0x0041;           // 获取详细的动态监测报警状态(对应 NET_CLIENT_DETAILEDMOTION_STATE)
    public static final int NET_DEVSTATE_VEHICLE_INFO          = 0x0042;           // 获取车载自身各种硬件信息(对应 NETDEV_VEHICLE_INFO)
    public static final int NET_DEVSTATE_VIDEOBLIND            = 0x0043;           // 获取视频遮挡报警状态(对应 NET_CLIENT_VIDEOBLIND_STATE)
    public static final int NET_DEVSTATE_3GSTATE_INFO          = 0x0044;           // 查询3G模块相关信息(对应结构体NETDEV_VEHICLE_3GMODULE)
    public static final int NET_DEVSTATE_NETINTERFACE          = 0x0045;           // 查询网络接口信息(对应 NETDEV_NETINTERFACE_INFO)

    public static final int NET_DEVSTATE_PICINPIC_CHN          = 0x0046;           // 查询画中画通道号(对应DWORD数组)
    public static final int NET_DEVSTATE_COMPOSITE_CHN         = 0x0047;           // 查询融合屏通道信息(对应 NET_COMPOSITE_CHANNEL数组)
    public static final int NET_DEVSTATE_WHOLE_RECORDING       = 0x0048;           // 查询设备整体录像状态(对应BOOL), 只要有一个通道在录像,即为设备整体状态为录像
    public static final int NET_DEVSTATE_WHOLE_ENCODING        = 0x0049;           // 查询设备整体编码状态(对应BOOL), 只要有一个通道在编码,即为设备整体状态为编码
    public static final int NET_DEVSTATE_DISK_RECORDE_TIME     = 0x004a;           // 查询设备硬盘录像时间信息(pBuf = DEV_DISK_RECORD_TIME*,可以有多个结构体)
    public static final int NET_DEVSTATE_BURNER_DOOR           = 0x004b;           // 是否已弹出刻录机光驱门(对应结构体 NET_DEVSTATE_BURNERDOOR)
    public static final int NET_DEVSTATE_GET_DATA_CHECK        = 0x004c;           // 查询光盘数据校验进度(对应 NET_DEVSTATE_DATA_CHECK)
    public static final int NET_DEVSTATE_ALARM_IN_CHANNEL      = 0x004f;           // 查询报警输入通道信息(对应NET_ALARM_IN_CHANNEL数组)
    public static final int NET_DEVSTATE_ALARM_CHN_COUNT       = 0x0050;           // 查询报警通道数(对应NET_ALARM_CHANNEL_COUNT)
    public static final int NET_DEVSTATE_PTZ_VIEW_RANGE        = 0x0051;           // 查询云台可视域状态(对应 NET_OUT_PTZ_VIEW_RANGE_STATUS	)
    public static final int NET_DEVSTATE_DEV_CHN_COUNT         = 0x0052;           // 查询设备通道信息(对应NET_DEV_CHN_COUNT_INFO)
    public static final int NET_DEVSTATE_RTSP_URL              = 0x0053;           // 查询设备支持的RTSP URL列表,见结构体DEV_RTSPURL_LIST
    public static final int NET_DEVSTATE_LIMIT_LOGIN_TIME      = 0x0054;           // 查询设备登录的在线超时时间,返回一个BTYE,（单位：分钟） ,0表示不限制,非零正整数表示限制的分钟数
    public static final int NET_DEVSTATE_GET_COMM_COUNT        = 0x0055;           // 获取串口数 见结构体NET_GET_COMM_COUNT
    public static final int NET_DEVSTATE_RECORDING_DETAIL      = 0x0056;           // 查询录象状态详细信息(pBuf = NET_RECORD_STATE_DETAIL*)
    public static final int NET_DEVSTATE_PTZ_PRESET_LIST       = 0x0057;           // 获取当前云台的预置点列表(对应结构NET_PTZ_PRESET_LIST)
    public static final int NET_DEVSTATE_EXTERNAL_DEVICE       = 0x0058;           // 外接设备信息(pBuf = NET_EXTERNAL_DEVICE*)
    public static final int NET_DEVSTATE_GET_UPGRADE_STATE     = 0x0059;           // 获取设备升级状态(对应结构 NETDEV_UPGRADE_STATE_INFO)
    public static final int NET_DEVSTATE_MULTIPLAYBACK_SPLIT_CAP = 0x005a;         // 获取多通道预览分割能力( 对应结构体 NET_MULTIPLAYBACK_SPLIT_CAP )
    public static final int NET_DEVSTATE_BURN_SESSION_NUM      = 0x005b;           // 获取刻录会话总数(pBuf = int*)
    public static final int NET_DEVSTATE_PROTECTIVE_CAPSULE    = 0X005c;           // 查询防护舱状态(对应结构体ALARM_PROTECTIVE_CAPSULE_INFO)
    public static final int NET_DEVSTATE_GET_DOORWORK_MODE     = 0X005d;           // 获取门锁控制模式( 对应 NET_GET_DOORWORK_MODE)
    public static final int NET_DEVSTATE_PTZ_ZOOM_INFO         = 0x005e;           // 查询云台获取光学变倍信息(对应 NET_OUT_PTZ_ZOOM_INFO )

    public static final int NET_DEVSTATE_POWER_STATE           = 0x0152;           // 查询电源状态(对应结构体NET_POWER_STATUS)
    public static final int NET_DEVSTATE_ALL_ALARM_CHANNELS_STATE  = 0x153;        // 查询报警通道状态(对应结构体 NET_CLIENT_ALARM_CHANNELS_STATE)
    public static final int NET_DEVSTATE_ALARMKEYBOARD_COUNT   = 0x0154;           // 查询串口上连接的报警键盘数(对应结构体NET_ALARMKEYBOARD_COUNT)
    public static final int NET_DEVSTATE_EXALARMCHANNELS       = 0x0155;           // 查询扩展报警模块通道映射关系(对应结构体 NET_EXALARMCHANNELS)
    public static final int NET_DEVSTATE_GET_BYPASS            = 0x0156;           // 查询通道旁路状态(对应结构体 NET_DEVSTATE_GET_BYPASS)
    public static final int NET_DEVSTATE_ACTIVATEDDEFENCEAREA  = 0x0157;           // 获取激活的防区信息(对应结构体 NET_ACTIVATEDDEFENCEAREA)
    public static final int NET_DEVSTATE_DEV_RECORDSET         = 0x0158;           // 查询设备记录集信息(对应 NET_CTRL_RECORDSET_PARAM)
    public static final int NET_DEVSTATE_DOOR_STATE            = 0x0159;           // 查询门禁状态(对应NET_DOOR_STATUS_INFO)
    public static final int NET_DEVSTATE_ANALOGALARM_CHANNELS  = 0x1560;           // 模拟量报警输入通道映射关系(对应NET_ANALOGALARM_CHANNELS)
    public static final int NET_DEVSTATE_GET_SENSORLIST        = 0x1561;           // 获取设备支持的传感器列表(对应 NET_SENSOR_LIST)
    public static final int NET_DEVSTATE_ALARM_CHANNELS        = 0x1562;           // 查询开关量报警模块通道映射关系(对应结构体 NET_ALARM_CHANNELS)
    																			   // 如果设备不支持查询扩展报警模块通道,可以用该功能查询扩展通道的逻辑通道号,并当做本地报警通道使用
    public static final int NET_DEVSTATE_GET_ALARM_SUBSYSTEM_ACTIVATESTATUS = 0x1563;  // 获取当前子系统启用状态( 对应 NET_GET_ALARM_SUBSYSTEM_ACTIVATE_STATUES)
    public static final int NET_DEVSTATE_AIRCONDITION_STATE    = 0x1564;           // 获取空调工作状态(对应 NET_GET_AIRCONDITION_STATE)
    public static final int NET_DEVSTATE_ALARMSUBSYSTEM_STATE  = 0x1565;           // 获取子系统状态(对应NET_ALARM_SUBSYSTEM_STATE)
    public static final int NET_DEVSTATE_ALARM_FAULT_STATE     = 0x1566;           // 获取故障状态(对应 NET_ALARM_FAULT_STATE_INFO)
    public static final int NET_DEVSTATE_DEFENCE_STATE         = 0x1567;           // 获取防区状态(对应 NET_DEFENCE_STATE_INFO, 和旁路状态变化事件、本地报警事件、报警信号源事件的状态描述有区别,不能混用,仅个别设备使用)
    public static final int NET_DEVSTATE_CLUSTER_STATE         = 0x1568;           // 获取集群状态(对应 NET_CLUSTER_STATE_INFO)
    public static final int NET_DEVSTATE_SCADA_POINT_LIST      = 0x1569;           // 获取点位表路径信息(对应 NET_SCADA_POINT_LIST_INFO)
    public static final int NET_DEVSTATE_SCADA_INFO            = 0x156a;           // 获取监测点位信息(对应 NET_SCADA_INFO)
    public static final int NET_DEVSTATE_SCADA_CAPS            = 0X156b;           // 获取SCADA能力集(对应 NET_SCADA_CAPS)
    public static final int NET_DEVSTATE_GET_CODEID_COUNT      = 0x156c;           // 获取对码成功的总条数(对应 NET_GET_CODEID_COUNT)
    public static final int NET_DEVSTATE_GET_CODEID_LIST       = 0x156d;           // 查询对码信息(对应 NET_GET_CODEID_LIST)
    public static final int NET_DEVSTATE_ANALOGALARM_DATA      = 0x156e;           // 查询模拟量通道数据(对应 NET_GET_ANALOGALARM_DATA)
    public static final int NET_DEVSTATE_VTP_CALLSTATE         = 0x156f;           // 获取视频电话呼叫状态(对应 NET_GET_VTP_CALLSTATE)
    public static final int NET_DEVSTATE_SCADA_INFO_BY_ID      = 0x1570;           // 通过设备、获取监测点位信息(对应 NET_SCADA_INFO_BY_ID)
    public static final int NET_DEVSTATE_SCADA_DEVICE_LIST     = 0x1571;           // 获取当前主机所接入的外部设备ID(对应 NET_SCADA_DEVICE_LIST)
    public static final int NET_DEVSTATE_DEV_RECORDSET_EX      = 0x1572;           // 查询设备记录集信息(带二进制数据)(对应NET_CTRL_RECORDSET_PARAM)
    public static final int NET_DEVSTATE_ACCESS_LOCK_VER       = 0x1573;           // 获取门锁软件版本号(对应 NET_ACCESS_LOCK_VER)
    public static final int NET_DEVSTATE_MONITORWALL_TVINFO    = 0x1574;           // 获取电视墙显示信息(对应 NET_CTRL_MONITORWALL_TVINFO)
    public static final int NET_DEVSTATE_GET_ALL_POS           = 0x1575;           // 获取所有用户可用Pos设备配置信息(对应 NET_POS_ALL_INFO)
    public static final int NET_DEVSTATE_GET_ROAD_LIST         = 0x1576;           // 获取城市及路段编码信息,哥伦比亚项目专用(对应 NET_ROAD_LIST_INFO)
    public static final int NET_DEVSTATE_GET_HEAT_MAP          = 0x1577;           // 获取热度统计信息(对应 NET_QUERY_HEAT_MAP)
    public static final int NET_DEVSTATE_GET_WORK_STATE        = 0x1578;           // 获取盒子工作状态信息(对应 NET_QUERY_WORK_STATE )
    public static final int NET_DEVSTATE_GET_WIRESSLESS_STATE  = 0x1579;           // 获取无线设备状态信息(对应 NET_GET_WIRELESS_DEVICE_STATE)
    public static final int NET_DEVSTATE_GET_REDUNDANCE_POWER_INFO = 0x157a;       // 获取冗余电源信息(对应 NET_GET_REDUNDANCE_POWER_INFO)

 
    // 查询设备信息类型, 对应接口 CLIENT_QueryDevInfo
    // 设备信息类型,对应CLIENT_QueryDevInfo接口
    public static final int NET_QUERY_DEV_STORAGE_NAMES                 = 0x01;                // 查询设备的存储模块名列表 , pInBuf=NET_IN_STORAGE_DEV_NAMES *, pOutBuf=NET_OUT_STORAGE_DEV_NAMES *
    public static final int NET_QUERY_DEV_STORAGE_INFOS                 = 0x02;                // 查询设备的存储模块信息列表, pInBuf=NET_IN_STORAGE_DEV_INFOS*, pOutBuf= NET_OUT_STORAGE_DEV_INFOS *
    public static final int NET_QUERY_RECENCY_JNNCTION_CAR_INFO         = 0x03;                // 查询最近的卡口车辆信息接口, pInBuf=NET_IN_GET_RECENCY_JUNCTION_CAR_INFO*, pOutBuf=NET_OUT_GET_RECENCY_JUNCTION_CAR_INFO*
    public static final int NET_QUERY_LANES_STATE                       = 0x04;                // 查询车道信息,pInBuf = NET_IN_GET_LANES_STATE , pOutBuf = NET_OUT_GET_LANES_STATE
    public static final int NET_QUERY_DEV_FISHEYE_WININFO               = 0x05;                // 查询鱼眼窗口信息 , pInBuf= NET_IN_FISHEYE_WININFO*, pOutBuf=NET_OUT_FISHEYE_WININFO *
    public static final int NET_QUERY_DEV_REMOTE_DEVICE_INFO            = 0x06;;               // 查询远程设备信息 , pInBuf= NET_IN_GET_DEVICE_INFO*, pOutBuf= NET_OUT_GET_DEVICE_INFO *
    public static final int NET_QUERY_SYSTEM_INFO                       = 0x07;                // 查询设备系统信息 , pInBuf= NET_IN_SYSTEM_INFO*, pOutBuf= NET_OUT_SYSTEM_INFO*
    public static final int NET_QUERY_REG_DEVICE_NET_INFO               = 0x08;                // 查询主动注册设备的网络连接 , pInBuf=NET_IN_REGDEV_NET_INFO * , pOutBuf=NET_OUT_REGDEV_NET_INFO *
    public static final int NET_QUERY_DEV_THERMO_GRAPHY_PRESET          = 0x09;                // 查询热成像预设信息 , pInBuf= NET_IN_THERMO_GET_PRESETINFO*, pOutBuf= NET_OUT_THERMO_GET_PRESETINFO *
    public static final int NET_QUERY_DEV_THERMO_GRAPHY_OPTREGION       = 0x0a;                // 查询热成像感兴趣区域信息,pInBuf= NET_IN_THERMO_GET_OPTREGION*, pOutBuf= NET_OUT_THERMO_GET_OPTREGION *
    public static final int NET_QUERY_DEV_THERMO_GRAPHY_EXTSYSINFO      = 0x0b;                // 查询热成像外部系统信息, pInBuf= NET_IN_THERMO_GET_EXTSYSINFO*, pOutBuf= NET_OUT_THERMO_GET_EXTSYSINFO *
    public static final int NET_QUERY_DEV_RADIOMETRY_POINT_TEMPER       = 0x0c;                // 查询测温点的参数值, pInBuf= NET_IN_RADIOMETRY_GETPOINTTEMPER*, pOutBuf= NET_OUT_RADIOMETRY_GETPOINTTEMPER *
    public static final int NET_QUERY_DEV_RADIOMETRY_TEMPER             = 0x0d;                // 查询测温项的参数值, pInBuf= NET_IN_RADIOMETRY_GETTEMPER*, pOutBuf= NET_OUT_RADIOMETRY_GETTEMPER *
    public static final int NET_QUERY_GET_CAMERA_STATE                  = 0x0e;                // 获取摄像机状态, pInBuf= NET_IN_GET_CAMERA_STATEINFO*, pOutBuf= NET_OUT_GET_CAMERA_STATEINFO *
    public static final int NET_QUERY_GET_REMOTE_CHANNEL_AUDIO_ENCODE   = 0x0f;                // 获取远程通道音频编码方式, pInBuf= NET_IN_GET_REMOTE_CHANNEL_AUDIO_ENCODEINFO*, pOutBuf= NET_OUT_GET_REMOTE_CHANNEL_AUDIO_ENCODEINFO *
    public static final int NET_QUERY_GET_COMM_PORT_INFO                = 0x10;                // 获取设备串口信息, pInBuf=NET_IN_GET_COMM_PORT_INFO* , pOutBuf=NET_OUT_GET_COMM_PORT_INFO* 
    public static final int NET_QUERY_GET_LINKCHANNELS                  = 0x11;                // 查询某视频通道的关联通道列表,pInBuf=NET_IN_GET_LINKCHANNELS* , pOutBuf=NET_OUT_GET_LINKCHANNELS*
    public static final int NET_QUERY_GET_VIDEOOUTPUTCHANNELS           = 0x12;                // 获取解码通道数量统计信息, pInBuf=NET_IN_GET_VIDEOOUTPUTCHANNELS*, pOutBuf=NET_OUT_GET_VIDEOOUTPUTCHANNELS*
    public static final int NET_QUERY_GET_VIDEOINFO                     = 0x13;                // 获取解码通道信息, pInBuf=NET_IN_GET_VIDEOINFO*, pOutBuf=NET_OUT_GET_VIDEOINFO*
    public static final int NET_QUERY_GET_ALLLINKCHANNELS               = 0x14;                // 查询全部视频关联通道列表,pInBuf=NET_IN_GET_ALLLINKCHANNELS* , pOutBuf=NET_OUT_GET_ALLLINKCHANNELS*
    public static final int NET_QUERY_VIDEOCHANNELSINFO                 = 0x15;                // 查询视频通道信息,pInBuf=NET_IN_GET_VIDEOCHANNELSINFO* , pOutBuf=NET_OUT_GET_VIDEOCHANNELSINFO*
    public static final int NET_QUERY_TRAFFICRADAR_VERSION              = 0x16;                // 查询雷达设备版本,pInBuf=NET_IN_TRAFFICRADAR_VERSION* , pOutBuf=NET_OUT_TRAFFICRADAR_VERSION*
    public static final int NET_QUERY_WORKGROUP_NAMES                   = 0x17;                // 查询所有的工作目录组名,pInBuf=NET_IN_WORKGROUP_NAMES* , pOutBuf=NET_OUT_WORKGROUP_NAMES*
    public static final int NET_QUERY_WORKGROUP_INFO                    = 0x18;                // 查询工作组信息,pInBuf=NET_IN_WORKGROUP_INFO* , pOutBuf=NET_OUT_WORKGROUP_INFO*
    public static final int NET_QUERY_WLAN_ACCESSPOINT                  = 0x19;                // 查询无线网络接入点信息,pInBuf=NET_IN_WLAN_ACCESSPOINT* , pOutBuf=NET_OUT_WLAN_ACCESSPOINT*
    public static final int NET_QUERY_GPS_INFO							= 0x1a;				   // 查询设备GPS信息,pInBuf=NET_IN_DEV_GPS_INFO* , pOutBuf=NET_OUT_DEV_GPS_INFO*
    public static final int NET_QUERY_IVS_REMOTE_DEVICE_INFO            = 0x1b;                // 查询IVS的前端设备所关联的远程设备信息, pInBuf = NET_IN_IVS_REMOTE_DEV_INFO*, pOutBuf = NET_OUT_IVS_REMOTE_DEV_INFO*
   
    // 设备能力类型, 对应CLIENT_GetDevCaps接口
    public static final int NET_THERMO_GRAPHY_CAPS                 		= 0x06;                // 热成像摄像头属性能力,pInBuf=NET_IN_THERMO_GETCAPS*, pOutBuf=NET_OUT_THERMO_GETCAPS*
    public static final int NET_RADIOMETRY_CAPS                 		= 0x07;                // 热成像测温全局配置能力,pInBuf=NET_IN_RADIOMETRY_GETCAPS*, pOutBuf=NET_OUT_RADIOMETRY_GETCAPS*                          
    
    /////////////////////////////////// 矩阵 ///////////////////////////////////////

    public static final int NET_MATRIX_INTERFACE_LEN          			= 16;          // 信号接口名称长度
    public static final int NET_MATRIX_MAX_CARDS             			= 128;         // 矩阵子卡最大数量
    public static final int NET_SPLIT_PIP_BASE               			= 1000;        // 分割模式画中画的基础值
    public static final int NET_MAX_SPLIT_MODE_NUM           			= 64;          // 最大分割模式数
    public static final int NET_MATRIX_MAX_CHANNEL_IN        			= 1500;        // 矩阵最大输入通道数
    public static final int NET_MATRIX_MAX_CHANNEL_OUT       			= 256;         // 矩阵最大输出通道数
    public static final int NET_DEVICE_NAME_LEN              			= 64;          // 设备名称长度
    public static final int NET_MAX_CPU_NUM                  			= 16;          // 最大CPU数量
    public static final int NET_MAX_FAN_NUM                  			= 16;          // 最大风扇数量
    public static final int NET_MAX_POWER_NUM                			= 16;          // 最大电源数量
    public static final int NET_MAX_BATTERY_NUM              			= 16;          // 最大电池数量
    public static final int NET_MAX_TEMPERATURE_NUM          			= 256;         // 最大温度传感器数量
    public static final int NET_MAX_ISCSI_NAME_LEN           			= 128;         // ISCSI名称长度
    public static final int NET_VERSION_LEN                  			= 64;          // 版本信息长度
    public static final int NET_MAX_STORAGE_PARTITION_NUM    			= 32;          // 存储分区最大数量
    public static final int NET_STORAGE_MOUNT_LEN            			= 64;          // 挂载点长度
    public static final int NET_STORAGE_FILE_SYSTEM_LEN      			= 16;          // 文件系统名称长度
    public static final int NET_MAX_MEMBER_PER_RAID          			= 32;          // RAID成员最大数量
    public static final int NET_DEV_ID_LEN_EX                			= 128;         // 设备ID最大长度
    public static final int NET_MAX_BLOCK_NUM                			= 32;          // 最大区块数量
    public static final int NET_MAX_SPLIT_WINDOW             			= 128;         // 最大分割窗口数量
    public static final int NET_FILE_TYPE_LEN                			= 64;          // 文件类型长度
    public static final int NET_DEV_ID_LEN                  			= 128;         // 设备ID最大长度
    public static final int NET_DEV_NAME_LEN                 			= 128;         // 设备名称最大长度
    public static final int NET_TSCHE_DAY_NUM                			= 8;           // 时间表第一维大小, 表示天数
    public static final int NET_TSCHE_SEC_NUM                			= 6;           // 时间表第二维大小, 表示时段数
    public static final int NET_SPLIT_INPUT_NUM              			= 256;         // 司法设备二级切换时第一级split支持的输入通道数

    public static final String NET_DEVICE_ID_LOCAL               		= "Local";     // 本地设备ID
    public static final String NET_DEVICE_ID_REMOTE              		= "Remote";    // 远程设备ID
    public static final String NET_DEVICE_ID_UNIQUE             		= "Unique";    // 设备内统一编号
    
    //其他定义
    public static final int NET_MAX_NAME_LEN                    = 16;   // 通用名字字符串长度
    public static final int NET_MAX_PERSON_ID_LEN               = 32;   // 人员id最大长度
    public static final int NET_MAX_PERSON_IMAGE_NUM            = 48;   // 每个人员对应的最大人脸图片数
    public static final int NET_MAX_PROVINCE_NAME_LEN           = 64;   // 省份名称最大长度
    public static final int NET_MAX_CITY_NAME_LEN               = 64;   // 城市名称最大长度
    public static final int NET_MAX_PERSON_NAME_LEN             = 64;   // 人员名字最大长度
    public static final int MAX_FACE_AREA_NUM                   = 8;    // 最大人脸区域个数
    public static final int MAX_PATH                            = 260;
    public static final int MAX_FACE_DB_NUM                     = 8;    // 最大人脸数据库个数
    public static final int MAX_GOURP_NUM                       = 128;  // 人脸库最大个数
    public static final int MAX_AGE_NUM						    = 2;	// 最大年龄个数
    public static final int MAX_EMOTION_NUM					    = 8;	// 最大表情条件的个数

    public static final int MAX_FIND_COUNT                      = 20;
    public static final int NET_MAX_POLYGON_NUM                 = 16;   // 多边形最大顶点个数
    public static final int NET_MAX_CANDIDATE_NUM               = 50;   // 人脸识别最大匹配数
    public static final int MAX_POLYGON_NUM                     = 20;   // 视频分析设备区域顶点个数上限
    public static final int MAX_CALIBRATEBOX_NUM                = 10;   // 智能分析校准框个数上限
    public static final int MAX_NAME_LEN                        = 128;  // 通用名字字符串长度
    public static final int MAX_EXCLUDEREGION_NUM               = 10;   // 智能分析检测区域中需要排除的区域个数上限
    public static final int MAX_OBJECT_LIST_SIZE                = 16;   // 视频分析设备支持的检测物体类型列表个数上限
    public static final int MAX_SPECIALDETECT_NUM               = 10;   // 智能分析特殊检测区域上限
    public static final int MAX_OBJECT_ATTRIBUTES_SIZE          = 16;   // 视频分析设备支持的检测物体属性类型列表个数上限
    public static final int MAX_CATEGORY_TYPE_NUMBER            = 128;  // 子类别类型数
    public static final int MAX_ANALYSE_MODULE_NUM              = 16;   // 视频分析设备最大检测模块个数
    public static final int MAX_LOG_PATH_LEN                    = 260;  // 日志路径名最大长度
    public static final int MAX_CHANNELNAME_LEN                 = 64;   // 最大通道名称长度
    public static final int MAX_VIDEO_CHANNEL_NUM               = 256;  // 最大通道数256
    public static final int MAX_PSTN_SERVER_NUM                 = 8;    // 最大报警电话服务器数
    public static final int MAX_TIME_SCHEDULE_NUM               = 8;    // 时间表元素个数
    public static final int MAX_REC_TSECT                       = 6;    // 录像时间段个数
    public static final int MAX_REC_TSECT_EX                    = 10;   // 录像时间段扩展个数
    public static final int MAX_NAS_TIME_SECTION                = 2;    // 网络存储时间段个数
    public static final int MAX_CHANNEL_COUNT                   = 16;
    public static final int MAX_ACCESSCONTROL_NUM               = 8;    // 最大门禁操作的组合数
    public static final int MAX_DBKEY_NUM                       = 64;   // 数据库关键字最大值
    public static final int MAX_SUMMARY_LEN                     = 1024; // 叠加到JPEG图片的摘要信息最大长度
    public static final int WEEK_DAY_NUM                        = 7;    // 一周的天数
    public static final int NET_MAX_FACEDETECT_FEATURE_NUM      = 32;   // 人脸特征最大个数
    public static final int NET_MAX_OBJECT_LIST                 = 16;   // 智能分析设备检测到的物体ID个数上限    
    public static final int NET_MAX_RULE_LIST                   = 16;   // 智能分析设备规则个数上限
    public static final int MAX_HUMANFACE_LIST_SIZE             = 8;    // 视频分析设备支持的人脸检测类型列表个数上限
    public static final int MAX_FEATURE_LIST_SIZE				= 32;	// 视频分析设备支持的人脸属性列表个数上限
    public static final int NET_MAX_DETECT_REGION_NUM           = 20;   // 规则检测区域最大顶点数
    public static final int NET_MAX_DETECT_LINE_NUM             = 20;   // 规则检测线最大顶点数
    public static final int NET_MAX_TRACK_LINE_NUM              = 20;   // 物体运动轨迹最大顶点数
    public static final int NET_MACADDR_LEN                     = 40;   // MAC地址字符串长度
    public static final int NET_DEV_TYPE_LEN                    = 32;   // 设备型号字符串（如"IPC-F725"）长度
    public static final int NET_DEV_SERIALNO_LEN                = 48;   // 序列号字符串长度
    public static final int NET_MAX_URL_LEN                     = 128;  // URL字符串长度
    public static final int NET_MAX_STRING_LEN                  = 128;
    public static final int NET_MACHINE_NAME_NUM                = 64;   // 机器名称长度
    public static final int NET_USER_NAME_LENGTH_EX             = 16;   // 用户名长度
    public static final int NET_USER_NAME_LENGTH                = 8;    // 用户名长度
    public static final int NET_USER_PSW_LENGTH                 = 8;    // 用户密码长度
    public static final int NET_EVENT_NAME_LEN                  = 128;  // 事件名称长度
    public static final int NET_MAX_LANE_NUM                    = 8;    // 视频分析设备每个通道对应车道数上限
    public static final int MAX_DRIVING_DIR_NUM                 = 16;   // 车道行驶方向最大个数
    public static final int FLOWSTAT_ADDR_NAME                  = 16;   // 上下行地点名长
    public static final int NET_MAX_DRIVINGDIRECTION            = 256;  // 行驶方向字符串长度
    public static final int COMMON_SEAT_MAX_NUMBER              = 8;    // 默认检测最大座驾个数
    public static final int NET_MAX_ATTACHMENT_NUM              = 8;    // 最大车辆物件数量
    public static final int NET_MAX_ANNUUALINSPECTION_NUM       = 8;    // 最大年检标识位置
    public static final int NET_MAX_EVENT_PIC_NUM				= 6;    // 最大原始图片张数
    public static final int NET_COMMON_STRING_4                 = 4;    // 通用字符串长度4
    public static final int NET_COMMON_STRING_8                 = 8;    // 通用字符串长度8
    public static final int NET_COMMON_STRING_16                = 16;   // 通用字符串长度16
    public static final int NET_COMMON_STRING_32                = 32;   // 通用字符串长度32
    public static final int NET_COMMON_STRING_64                = 64;   // 通用字符串长度64
    public static final int NET_COMMON_STRING_128               = 128;  // 通用字符串长度128
    public static final int NET_COMMON_STRING_256               = 256;  // 通用字符串长度256
    public static final int NET_COMMON_STRING_512               = 512;  // 通用字符串长度512
    public static final int NET_COMMON_STRING_1024              = 1024; // 通用字符串长度1024
    public static final int NET_COMMON_STRING_2048              = 2048; // 通用字符串长度2048
    public static final int MAX_VIDEOSTREAM_NUM                 = 4;    // 最大码流个数
    public static final int MAX_VIDEO_COVER_NUM                 = 16;   // 最大遮挡区域个数
    public static final int MAX_VIDEO_IN_ZOOM                   = 32;   // 单通道最大变速配置个数
    public static final int NET_EVENT_CARD_LEN                  = 36;   // 卡片名称长度
    public static final int NET_EVENT_MAX_CARD_NUM              = 16;   // 事件上报信息包含最大卡片个数
    public static final int MAX_STATUS_NUM                      = 16;   // 交通设备状态最大个数
    public static final int NET_MAX_CHANMASK 					= 64;   // 通道掩码最大值
    public static final int NET_CHAN_NAME_LEN                   = 32;   // 通道名长度,DVR DSP能力限制,最多32字节 
    public static final int MAX_LANE_NUM                        = 8;    // 视频分析设备每个通道对应车道数上限
    public static final int MAX_STAFF_NUM                       = 20;   // 视频分析设备每个通道对应的标尺数上限
    public static final int MAX_ANALYSE_RULE_NUM                = 32;   // 视频分析设备最大规则个数
    public static final int MAX_POLYLINE_NUM                    = 20;   // 视频分析设备折线顶点个数上限
    public static final int MAX_TEMPLATEREGION_NUM              = 32;   // 视频分析设备模拟区域信息点对个数上限
    public static final int POINT_PAIR_NUM                      = 2;    // 视频分析设备模拟区域点对包含的点个数
    public static final int MAX_VEHICLE_SIZE_LIST               = 4;    // 视频分析设备车辆大小个数上限
    public static final int MAX_VEHICLE_TYPE_LIST               = 4;    // 视频分析设备车辆类型个数上限
    public static final int MAX_PLATE_TYPE_LIST                 = 32;   // 视频分析设备车牌类型个数上限
    public static final int MAX_CALIBRATEAREA_NUM               = 20;   // 视频分析设备标定区域的上限
    public static final int MAX_ANALYSE_SCENE_NUM               = 32;   // 视频分析全局配置场景最大数量
    public static final int MAX_PLATEHINT_NUM                   = 8;    // 车牌字符暗示个数上限
    public static final int MAX_LIGHT_NUM                       = 8;    // 交通灯个数上限
    public static final int MAX_LIGHTGROUP_NUM                  = 8;    // 交通灯组个数上限
    public static final int MAX_LIGHT_TYPE                      = 8;    // 交通灯类型上限
    public static final int MAX_PARKING_SPACE_NUM          		= 6;    // 最多配置6个车位信息
    public static final int MAX_SHIELD_AREA_NUM            		= 16;   // 1个车位最多对应16个屏蔽区域
    public static final int MAX_SCENE_TYPE_LIST_SIZE            = 8;    // 场景列表中最多支持的场景个数
    public static final int MAX_LIGHT_DIRECTION                 = 8;    // 交通灯指示方向数上限
    public static final int CFG_FLOWSTAT_ADDR_NAME			    = 16;	//上下行地点名长
    public static final int MAX_ACCESS_READER_NUM               = 32;   // 门禁单个门最大读卡器数量
    public static final int MAX_ACCESSSUBCONTROLLER_NUM         = 64;   // 最大门禁分控器数量
    public static final int MAX_BACKPIC_COUNT					= 8;	// 最大背景图片个数
    public static final int NET_WIRELESS_DEVICE_SERIAL_NUMBER_MAX_LEN = 32;// 无线设备序列号最大长度
    public static final int NET_MAX_CUSTOM_PERSON_INFO_NUM		= 4;    // 注册人员信息扩展最大个数
    public static final int NET_MAX_PERSON_INFO_LEN         	= 64;   // 人员扩展信息最大长度
    
    public static final int NET_NEW_MAX_RIGHT_NUM               = 1024; // 用户权限个数上限
    public static final int NET_MAX_GROUP_NUM                   = 20;   // 用户组个数上限
    public static final int NET_MAX_USER_NUM                    = 200;  // 用户个数上限
    public static final int NET_RIGHT_NAME_LENGTH               = 32;   // 权限名长度
    public static final int NET_MEMO_LENGTH                     = 32;   // 备注长度
    public static final int NET_NEW_USER_NAME_LENGTH            = 128;  // 用户名长度
    public static final int NET_NEW_USER_PSW_LENGTH             = 128;  // 密码   
	public static final int NET_MAX_RIGHT_NUM                   = 100;  // 用户权限个数上限
	public static final int NET_COMMENT_LENGTH					= 100;	// 备注信息长度
	public static final int NET_GROUPID_LENGTH					= 64;	// group id 信息长度
	public static final int NET_GROUPNAME_LENGTH				= 128;	// group name 信息长度
	public static final int NET_FEATUREVALUE_LENGTH				= 128;	// 人脸特征 信息长度
	
	public static final int	MAX_GROUP_ID_LEN					= 64;	// 最大布控组ID长度
	public static final int	MAX_COLOR_NAME_LEN					= 32;	// 最大颜色名长度
	public static final int	MAX_COLOR_HEX_LEN					= 8;	// 最大HEX颜色长度
	public static final int	MAX_LINK_GROUP_NUM					= 20;	// 联动的布控组最大数量
	public static final int MAX_PATH_LEN					    = 260;	// 最大路径长度	
	public static final int MAX_RIDER_NUM 						= 16;	// 骑车人数组上限
	public static final int MAX_ALARM_CHANNEL_NAME_LEN		    = 64;   // 最大报警名称长度
	public static final int MAX_SMALLPIC_NUM				    = 32;	// 最大小图张数
	
	// 支持用户名最大长度为8位或16位的设备,对应扩展接口CLIENT_QueryUserInfoEx和CLIENT_OperateUserInfoEx
	public static final int NET_USER_PSW_LENGTH_EX       		= 16;   // 密码

    public static final int AV_CFG_Device_ID_Len				= 64;   // 设备ID长度
    public static final int AV_CFG_Channel_Name_Len             = 64;   // 通道名称长度
    public static final int AV_CFG_Monitor_Name_Len				= 64;	// 电视墙名称长度
    public static final int AV_CFG_Max_TV_In_Block				= 128;	// 区块中TV的最大数量
    public static final int AV_CFG_Max_Block_In_Wall			= 128;	// 电视墙中区块的最大数量
    public static final int AV_CFG_IP_Address_Len				= 32;   // IP 长度
    public static final int AV_CFG_Protocol_Len 				= 32;   // 协议名长度
    public static final int AV_CFG_User_Name_Len 				= 64;   // 用户名长度
    public static final int	AV_CFG_Password_Len 				= 64;   // 密码长度
    public static final int AV_CFG_Serial_Len					= 32;	// 序列号长度
    public static final int AV_CFG_Device_Class_Len				= 16;   // 设备类型长度
    public static final int AV_CFG_Device_Type_Len				= 32;	// 设备具体型号长度
    public static final int AV_CFG_Device_Name_Len				= 128;	// 机器名称
    public static final int AV_CFG_Address_Len					= 128;	// 机器部署地点
    public static final int AV_CFG_Max_Path						= 260;	// 路径长度
    public static final int AV_CFG_Group_Name_Len               = 64;   // 分组名称长度
    public static final int AV_CFG_DeviceNo_Len                 = 32;   // 设备编号长度
    public static final int AV_CFG_Group_Memo_Len               = 128;  // 分组说明长度
    public static final int AV_CFG_Max_Channel_Num              = 1024; // 最大通道数量
    public static final int MAX_DEVICE_NAME_LEN					= 64;   // 机器名称
    public static final int MAX_DEV_ID_LEN_EX					= 128;  // 设备ID最大长度
    public static final int MAX_PATH_STOR                       = 240;  // 远程目录的长度
    public static final int	MAX_REMOTE_DEV_NUM       			= 256;  // 最大远程设备数量
    public static final int NET_MAX_PLATE_NUMBER_LEN            = 32;   // 车牌字符长度    
    public static final int NET_MAX_AUTHORITY_LIST_NUM          = 16;   // 权限列表最大个数    
    public static final int NET_MAX_ALARMOUT_NUM_EX 			= 32;   //报警输出口个数上限扩展
    public static final int NET_MAX_VIDEO_IN_NUM_EX 			= 32;   //视频输入口个数上限扩展
    public static final int NET_MAX_SAERCH_IP_NUM               = 256;  // 最大搜索IP个数
    public static final int NET_MAX_POS_MAC_NUM                 = 8;    // 刷卡机Mac码最大长度
    public static final int NET_MAX_BUSCARD_NUM                 = 64;   // 公交卡号最大长度
    public static final int NET_STORAGE_NAME_LEN                = 128;  // 存储设备名称长度
    
    public static final int NET_MAX_DOOR_NUM               		= 32;   // 最大有权限门禁数目
    public static final int NET_MAX_TIMESECTION_NUM        		= 32;   // 最大有效时间段数目
    public static final int NET_MAX_CARDNAME_LEN           		= 64;   // 门禁卡命名最大长度
    public static final int NET_MAX_CARDNO_LEN             		= 32;   // 门禁卡号最大长度
    public static final int NET_MAX_USERID_LEN             		= 32;   // 门禁卡用户ID最大长度
    public static final int NET_MAX_IC_LEN				  		= 32;	// 身份证最大长度
    public static final int NET_MAX_QRCODE_LEN			  		= 128;	// QRCode 最大长度
    public static final int NET_MAX_CARD_INFO_LEN               = 256;  // 卡号信息最大长度
    public static final int NET_MAX_SIM_LEN                     = 16;   // SIM卡的值的最大长度
    public static final int NET_MAX_DISKNUM                     = 256;  // 最大硬盘个数
    public static final int MAX_FACE_DATA_NUM                	= 20;   // 人脸模版最大个数
    public static final int MAX_FINGERPRINT_NUM              	= 10;   // 最大指纹个数
    public static final int MAX_FACE_DATA_LEN                   = 2 * 1024; // 人脸模版数据最大长度
    public static final int MAX_COMMON_STRING_8              	= 8;    // 通用字符串长度8
    public static final int MAX_COMMON_STRING_16             	= 16;   // 通用字符串长度16
    public static final int MAX_COMMON_STRING_32             	= 32;   // 通用字符串长度32
    public static final int MAX_COMMON_STRING_64             	= 64;   // 通用字符串长度64
    public static final int MAX_COMMON_STRING_128               = 128;  // 通用字符串长度128
    public static final int MAX_USER_NAME_LEN                   = 128;  // 最大用户名长度
    public static final int MAX_ROOMNUM_COUNT					= 32;	// 房间最大个数
    public static final int MAX_FACE_COUTN						= 20;	// 人脸模板数据最大个数
    public static final int MAX_PHOTO_COUNT                     = 5;    // 人脸照片最大个数
    public static final int MAX_WINDOWS_COUNT					= 16;	// 诱导屏最大窗口个数
    public static final int MAX_CLASS_NUMBER_LEN			    = 32;	// 最大班级长度
    public static final int MAX_PHONENUMBER_LEN				    = 16;   // 最大电话长度
    public static final int MAX_NASFILE_NUM                     = 8;    // 最大NAS文件个数
    public static final int MAX_CELL_PHONE_NUMBER_LEN           = 32;   // 最大手机号长度
    public static final int MAX_MAIL_LEN                        = 64;   // 邮箱最大长度
    public static final int MAX_PWD_LEN                         = 128;  // 最大密码长度
    public static final int MAX_ACCESS_FLOOR_NUM                = 64;   // 最大楼层数量
    public static final int MAX_ORDER_NUMBER 					= 6;	// 排序规则的最大数量
    public static final int MAX_NUMBER_REGISTER_INFO			= 32;
    
	public static final int CFG_COMMON_STRING_8                 = 8;    // 通用字符串长度8
	public static final int CFG_COMMON_STRING_16                = 16;   // 通用字符串长度16
	public static final int CFG_COMMON_STRING_32                = 32;   // 通用字符串长度32
	public static final int CFG_COMMON_STRING_64                = 64;   // 通用字符串长度64
	public static final int CFG_COMMON_STRING_128               = 128;  // 通用字符串长度128
	public static final int CFG_COMMON_STRING_256               = 256;  // 通用字符串长度256
	public static final int CFG_COMMON_STRING_512               = 512;  // 通用字符串长度512
    
    public static final int MAX_COILCONFIG          			= 3;    // 智能交通车检器线圈配置上限
    public static final int MAX_DETECTOR            			= 6;    // 智能交通车检器配置上限
    public static final int MAX_VIOLATIONCODE					= 16;   // 智能交通违章代码长度上限
    public static final int MAX_LANE_CONFIG_NUMBER              = 32;   // 车道最大个数
    public static final int MAX_VIOLATIONCODE_DESCRIPT          = 64;   // 智能交通违章代码长度上限
    public static final int MAX_ROADWAYNO           			= 128;  // 道路编号	由32个数字和字母构成
    public static final int MAX_PRIORITY_NUMBER                 = 256;  // 违章优先级包含违章最大个数
    public static final int MAX_DRIVINGDIRECTION          		= 256;  // 行驶方向字符串长度
    
    public static final int MAX_OSD_CUSTOM_SORT_NUM       		= 8;
    public static final int MAX_OSD_CUSTOM_SORT_ELEM_NUM  		= 8;
    public static final int MAX_OSD_CUSTOM_GENERAL_NUM    		= 8;
    public static final int MAX_OSD_ITEM_ATTR_NUM         		= 8;
    public static final int MAX_PRE_POX_STR_LEN           		= 32;
    public static final int MAX_OSD_CUSTOM_NAME_LEN       		= 32;
    public static final int MAX_OSD_CUSTOM_VALUE_LEN      		= 256;
    public static final int MAX_CONF_CHAR 						= 256;
    public static final int MAX_IVS_EVENT_NUM    				= 256;
    public static final int MAX_QUERY_USER_NUM   				= 4;    // 最大查询用户个数
    public static final int MAX_DEVICE_ADDRESS      			= 256;  // TrafficSnapshot智能交通设备地址
    public static final int MAX_STORAGE_NUM                 	= 8;    // 存储设备最大个数
    public static final int MAX_PARTITION_NUM               	= 8;    // 最大分区个数
    public static final int MAX_SCADA_POINT_LIST_INFO_NUM       = 256;  // 最大点位表路径个数
    public static final int MAX_SCADA_POINT_LIST_ALARM_INFO_NUM = 256;  // 最大点位表报警个数
    public static final int	MAX_LABEL_ARRAY						= 1024;
    
    public static final int	MAX_DELIVERY_FILE_NUM  				= 128;  // 最大投放文件数量
    public static final int	DELIVERY_FILE_URL_LEN  				= 128;  // 投放文件的URL长度
    
    public static final int MAX_COMMON_STRING_512               = 512;  // 通用字符串长度512
    public static final int	MAX_RFIDELETAG_CARDID_LEN		    = 16;	// RFID 电子车牌标签信息中卡号最大长度
    public static final int	MAX_RFIDELETAG_DATE_LEN		 	    = 16;	// RFID 电子车牌标签信息中时间最大长度
    public static final int MAX_REPEATENTERROUTE_NUM   			= 12;   //反潜路径个数  
    public static final int ECK_SCREEN_NUM_MAX                  = 8;    // 智能停车系统出入口机最大屏数量
    public static final int MAX_CAR_CANDIDATE_NUM				= 50;
    public static final int MAX_REGISTER_NUM                    = 10;   // 主动注册配置最大个数 
    public static final int MAX_SERVER_NUM                      = 10;   // 服务器最大个数
    public static final int	NET_COUNTRY_LENGTH				    = 3;	// 国家缩写长度
    public static final int	MAX_ATTENDANCE_USERNAME_LEN			= 36;	// 考勤用户名长度
    public static final int	NET_MAX_FINGER_PRINT				= 10;	// 指纹最大个数
    public static final int	MAX_EVENT_ID_LEN					= 52;   // 国标事件ID最大长度
    public static final int	MAX_HUMANTRAIT_EVENT_LEN			= 36; 	// 补充人体特征上报事件最大长度
    public static final int MAX_EXIT_MAN_NUM					= 32;	// 最大支持的离开人员数量
    
    // 矩阵子卡类型, 多种类型可以组合
    public static final int NET_MATRIX_CARD_MAIN                = 0x10000000;   // 主卡
    public static final int NET_MATRIX_CARD_INPUT               = 0x00000001;   // 输入卡
    public static final int NET_MATRIX_CARD_OUTPUT              = 0x00000002;   // 输出卡
    public static final int NET_MATRIX_CARD_ENCODE              = 0x00000004;   // 编码卡
    public static final int NET_MATRIX_CARD_DECODE              = 0x00000008;   // 解码卡
    public static final int NET_MATRIX_CARD_CASCADE             = 0x00000010;   // 级联卡
    public static final int NET_MATRIX_CARD_INTELLIGENT         = 0x00000020;   // 智能卡
    public static final int NET_MATRIX_CARD_ALARM               = 0x00000040;   // 报警卡
    public static final int NET_MATRIX_CARD_RAID                = 0x00000080;   // 硬Raid卡
    public static final int NET_MATRIX_CARD_NET_DECODE          = 0x00000100;   // 网络解码卡
    
    public static final int RESERVED_TYPE_FOR_INTEL_BOX 		= 0x00000001;
    public static final int RESERVED_TYPE_FOR_COMMON   			= 0x00000010;
    
    //回放速度
    public static final int NET_SDK_RPB_SPEED_1_32X             = 1;//1/32倍速
    public static final int NET_SDK_RPB_SPEED_1_16X             = 2;//1/16倍速
    public static final int NET_SDK_RPB_SPEED_1_8X              = 3;//1/8倍速
    public static final int NET_SDK_RPB_SPEED_1_4X              = 4;//1/4倍速
    public static final int NET_SDK_RPB_SPEED_1_2X              = 5;//1/2倍速
    public static final int NET_SDK_RPB_SPEED_1X                = 6;//1倍速
    public static final int NET_SDK_RPB_SPEED_2X                = 7;//2倍速
    public static final int NET_SDK_RPB_SPEED_4X                = 8;//4倍速
    public static final int NET_SDK_RPB_SPEED_8X                = 9;//8倍速
    public static final int NET_SDK_RPB_SPEED_16X               = 10;//16倍速
    public static final int NET_SDK_RPB_SPEED_32X               = 11;//32倍速
    //回放控制
    public static final int NET_SDK_PLAYCTRL_PAUSE              = 0;//暂停
    public static final int NET_SDK_PLAYCTRL_FF              	= 1;//加速
    public static final int NET_SDK_PLAYCTRL_REW              	= 2;//减速
    public static final int NET_SDK_PLAYCTRL_RESUME             = 3;//恢复
    public static final int NET_SDK_PLAYCTRL_STOP              	= 4;//停止
    public static final int NET_SDK_PLAYCTRL_FRAME              = 5;//帧进
    public static final int NET_SDK_PLAYCTRL_NORMAL             = 6;//正常
    public static final int NET_SDK_PLAYCTRL_STARTAUDIO         = 7;//该控制类型及以下两个控制类型只有在SDK内部解码显示时才会起作用
    public static final int NET_SDK_PLAYCTRL_STOPAUDIO          = 8;//
    public static final int NET_SDK_PLAYCTRL_AUDIOVOLUME        = 9;//
    public static final int NET_SDK_PLAYCTRL_SETPOS             = 10;//
    
    //NET_SDK_N9000_ALARM_TYPE
    public static final int NET_SDK_N9000_ALARM_TYPE_MOTION     = 1;//motion alarm
    public static final int NET_SDK_N9000_ALARM_TYPE_SENSOR     = 2;//传感器报警输入 sensor alarm
    public static final int NET_SDK_N9000_ALARM_TYPE_VLOSS      = 3;////视频丢失报警输入 video loss
    public static final int NET_SDK_N9000_ALARM_TYPE_FRONT_OFFLINE = 4;//前端设备掉线报警 device offline
    public static final int NET_SDK_N9000_ALARM_TYPE_OSC           = 5;//物品看护侦测报警 object remove
    public static final int NET_SDK_N9000_ALARM_TYPE_AVD           = 6;////视频异常侦测报警 abnormal video detection
    public static final int NET_SDK_N9000_ALARM_TYPE_AVD_SCENE     = 7;//only IPC
    public static final int NET_SDK_N9000_ALARM_TYPE_AVD_CLARITY   = 8;//only IPC
    public static final int NET_SDK_N9000_ALARM_TYPE_AVD_COLOR     = 9;//only IPC
    public static final int NET_SDK_N9000_ALARM_TYPE_PEA_TRIPWIRE  = 10; //越界侦测报警 trip wire alarm 
    public static final int NET_SDK_N9000_ALARM_TYPE_PEA_PERIMETER = 11; //区域入侵侦测报警 perimeter alarm
    public static final int NET_SDK_N9000_ALARM_TYPE_DISK_IO_ERROR = 103;//磁盘IO错误 disk io error
    public static final int NET_SDK_N9000_ALARM_TYPE_DISK_FULL     = 104;//磁盘满 disk full
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int
//    public static final int

}
