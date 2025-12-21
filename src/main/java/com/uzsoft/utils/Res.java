package com.uzsoft.utils;

import lombok.Getter;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Res {
	
	@Getter
    private static ResourceBundle bundle;
	private static final Res instance;
	static {
		instance = new Res();
	}
	
	private Res() {
		switchLanguage(LanguageType.Russian);
	}

	public static Res string() {
		return instance;
	}

	public String getElectronWeight() {
		return bundle.getString("ELECTRON_WEIGHT");
	}
	public String getScaleIndicator() {
		return bundle.getString("WEIGHT_INDICATOR");
	}
	public String getDirection() {
		return bundle.getString("DIRECTION");
	}
	public String getCarNumber() {
		return bundle.getString("AUTO_NUMBER");
	}
	public String getCarModel() {
		return bundle.getString("AUTO_MODEL");
	}
	public String getCarDriver() {
		return bundle.getString("CAR_DRIVER");
	}
	public String getProductName() {
		return bundle.getString("PRODUCT_TYPE");
	}
	public String getSender() {
		return bundle.getString("SENDER");
	}
	public String getReceiver() {
		return bundle.getString("RECEIVER");
	}
	public String getOperator() {
		return bundle.getString("OPERATOR");
	}
	public String getSave() {
		return bundle.getString("SAVE");
	}
	public String getReport() {
		return bundle.getString("REPORT");
	}
	public String getSettings() {
		return bundle.getString("SETTINGS");
	}
	public String getCameraError() {
		return bundle.getString("CAMERA_ERROR");
	}
	public String getError() {
		return bundle.getString("ERROR");
	}
	public String getGross() {
		return bundle.getString("GROSS");
	}
	public String getTare() {
		return bundle.getString("TARE");
	}
	public String getNet() {
		return bundle.getString("NET");
	}
	public String getToday() {
		return bundle.getString("TODAY");
	}
	public static String localize(String code) {
		return bundle.getString(code);
	}

	public enum LanguageType {
		Uzbek,
		Russian,
		English
	}

    public static void switchLanguage(LanguageType type) {
		switch(type) {
            case Russian:
				bundle = ResourceBundle.getBundle("res", new Locale("ru", "RU"));
				break;
			case English:
				bundle = ResourceBundle.getBundle("res", new Locale("en", "US"));
				break;
			default:
				bundle = ResourceBundle.getBundle("res", new Locale("uz", "UZ"));
				break;
		}
	}
	
	public String getLanguage() {
		return bundle.getString("LANGUAGE");
	}

	public String getSwitchLanguage() {
		return bundle.getString("SWITCH_LANGUAGE");
	}
	
	public String getDisConnectReconnecting() {
		return bundle.getString("DISCONNECT_RECONNECTING");
	}
	
	public String getDisConnect() {
		return bundle.getString("DISCONNECT");
	}
	
	public String getPromptMessage() {
		return bundle.getString("PROMPT_MESSAGE");
	}
	
	public String getErrorMessage() {
		return bundle.getString("ERROR_MESSAGE");
	}
	
	public String getReconnectSucceed() {
		return bundle.getString("RECONNECT_SUCCEED");
	}
	
	public String getSucceed() {
		return bundle.getString("SUCCEED");
	}
	
	public String getFailed() {
		return bundle.getString("FAILED");
	}
	
	public String getYear() {
		return bundle.getString("YEAR");
	}
	
	public String getMonth() {
		return bundle.getString("MONTH");
	}
	
	public String getDay() {
		return bundle.getString("DAY");
	}
	
	public String getHour() {
		return bundle.getString("HOUR");
	}
	
	public String getMinute() {
		return bundle.getString("MINUTE");
	}
	
	public String getSecond() {
		return bundle.getString("SECOND");
	}
	
	public String getSunday() {
		return bundle.getString("SUNDAY");
	}
	
	public String getMonday() {
		return bundle.getString("MONDAY");
	}
	
	public String getTuesday() {
		return bundle.getString("TUESDAY");
	}
	
	public String getWednesday() {
		return bundle.getString("WEDNESDAY");
	}
	
	public String getThursday() {
		return bundle.getString("THURSDAY");
	}
	
	public String getFriday() {
		return bundle.getString("FRIDAY");
	}
	
	public String getSaturday() {
		return bundle.getString("SATURDAY");
	}
	
	public String[] getWeek() {

        return new String[]{getSunday(),
                             getMonday(),
                             getTuesday(),
                             getWednesday(),
                             getThursday(),
                             getFriday(),
                             getSaturday()
        };
	}
	
	public String getConfirm() {
		return bundle.getString("CONFIRM");
	}
	
	public String getCancel() {
		return bundle.getString("CANCEL");
	}

	public String getLogin() {
		return bundle.getString("LOGIN");
	}
	
	public String getLogout() {
		return bundle.getString("LOGOUT");
	}
	
	public String getDeviceIp() {
		return bundle.getString("DEVICE_IP");
	}
	
	public String getIp() {
		return bundle.getString("IP");
	}
	
	public String getPort() {
		return bundle.getString("DEVICE_PORT");
	}

	public String getUserName() {
		return bundle.getString("USERNAME");
	}
	
	public String getPassword() {
		return bundle.getString("PASSWORD");
	}
	
	public String getChannel() {
		return bundle.getString("CHANNEL");
	}

	public String getPTZ() {
		return bundle.getString("PTZ");
	}

	public String getLeft() {
		return bundle.getString("LEFT");
	}
	
	public String getRight() {
		return bundle.getString("RIGHT");
	}

	public String getSpeed() {
		return bundle.getString("SPEED");
	}

	public String getIndex() {
		return bundle.getString("INDEX");
	}

    public String getStartTime() {
    	return bundle.getString("START_TIME");
    }
    
    public String getEndTime() {
    	return bundle.getString("END_TIME");
    }

    public String getStart() {
    	return bundle.getString("START");
    }
    
    public String getStop() {
    	return bundle.getString("STOP");
    }
    
    public String getSetTime() {
    	return bundle.getString("SET_TIME");
    }
    
    public String getTime() {
    	return bundle.getString("TIME");
    }
    public String getAction() {
    	return bundle.getString("ACTION");
    }
    
    public String getMask() {
    	return bundle.getString("MASK");
    }
    
    public String getName() {
    	return bundle.getString("NAME");
    }
    
    public String getUnknown() {
    	return bundle.getString("UNKNOW");
    }
    
    public String getMale() {
    	return bundle.getString("MALE");
    }
    
    public String getFemale() {
    	return bundle.getString("FEMALE");
    }

    public String[] getSexStrings() {
        return new String[]{getUnknown(), getMale(), getFemale()};
    }

	public String getSex(int sex) {
		return switch (sex) {
			case 0 -> getUnknown();
			case 1 -> getMale();
			case 2 -> getFemale();
			default -> getUnknown();
		};
	}
    
    public String getUnLimited() {
    	return bundle.getString("UNLIMITED");
    }

	public String getAdd() {
		return bundle.getString("ADD");
	}

	public String getGet() {
		return bundle.getString("GET");
	}
	
	public String getSet() {
		return bundle.getString("SET");
	}

	public String getRecord() {
		return bundle.getString("RECORD");
	}

	public String getUserList() {
		return bundle.getString("USER_LIST");
	}

	public String getCard() {
		return bundle.getString("CARD");
	}

	public String getGate() {
		return bundle.getString("GATE");
	}

	public String getClear() {
		return bundle.getString("CLEAR");
	}

	public String getValid() {
		return bundle.getString("VALID");
	}

	public String getShowInfo(String tag) {
		try {
			return bundle.getString(tag);
		}catch(Exception e) {
			return tag;
		}
	}
}
