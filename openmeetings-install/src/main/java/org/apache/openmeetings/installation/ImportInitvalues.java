/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openmeetings.installation;

import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_APPLICATION_BASE_URL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_APPLICATION_NAME;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_APPOINTMENT_REMINDER_MINUTES;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_CALENDAR_FIRST_DAY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_CALENDAR_ROOM_CAPACITY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_CRYPT;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DASHBOARD_RSS_FEED1;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DASHBOARD_RSS_FEED2;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DASHBOARD_SHOW_CHAT;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DASHBOARD_SHOW_MYROOMS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DASHBOARD_SHOW_RSS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DEFAULT_GROUP_ID;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DEFAULT_LANDING_ZONE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DEFAULT_LANG;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DEFAULT_LDAP_ID;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DEFAULT_TIMEZONE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DOCUMENT_DPI;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_DOCUMENT_QUALITY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_EMAIL_AT_REGISTER;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_EMAIL_VERIFICATION;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_EXT_PROCESS_TTL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_CAM_QUALITY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_ECHO_PATH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_MIC_RATE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_SECURE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_SECURE_PROXY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_VIDEO_BANDWIDTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_VIDEO_CODEC;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_FLASH_VIDEO_FPS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_GOOGLE_ANALYTICS_CODE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_HEADER_CSP;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_HEADER_XFRAME;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_IGNORE_BAD_SSL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_KEYCODE_ARRANGE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_KEYCODE_EXCLUSIVE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_KEYCODE_MUTE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_LOGIN_MIN_LENGTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_MAX_UPLOAD_SIZE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_PASS_MIN_LENGTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_PATH_FFMPEG;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_PATH_IMAGEMAGIC;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_PATH_OFFICE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_PATH_SOX;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_REDIRECT_URL_FOR_EXTERNAL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_REGISTER_FRONTEND;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_REGISTER_OAUTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_REGISTER_SOAP;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_REPLY_TO_ORGANIZER;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SCREENSHARING_ALLOW_REMOTE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SCREENSHARING_FPS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SCREENSHARING_FPS_SHOW;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SCREENSHARING_QUALITY;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SIP_ENABLED;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SIP_EXTEN_CONTEXT;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SIP_ROOM_PREFIX;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_PASS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_PORT;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_SERVER;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_SYSTEM_EMAIL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_TIMEOUT;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_TIMEOUT_CON;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_TLS;
import static org.apache.openmeetings.util.OpenmeetingsVariables.CONFIG_SMTP_USER;
import static org.apache.openmeetings.util.OpenmeetingsVariables.DEFAULT_APP_NAME;
import static org.apache.openmeetings.util.OpenmeetingsVariables.DEFAULT_MAX_UPLOAD_SIZE;
import static org.apache.openmeetings.util.OpenmeetingsVariables.EXT_PROCESS_TTL;
import static org.apache.openmeetings.util.OpenmeetingsVariables.HEADER_CSP_SELF;
import static org.apache.openmeetings.util.OpenmeetingsVariables.HEADER_XFRAME_SAMEORIGIN;
import static org.apache.openmeetings.util.OpenmeetingsVariables.LEVEL_ADMIN;
import static org.apache.openmeetings.util.OpenmeetingsVariables.LEVEL_GROUP_ADMIN;
import static org.apache.openmeetings.util.OpenmeetingsVariables.LEVEL_USER;
import static org.apache.openmeetings.util.OpenmeetingsVariables.MENU_ROOMS_NAME;
import static org.apache.openmeetings.util.OpenmeetingsVariables.USER_LOGIN_MINIMUM_LENGTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.USER_PASSWORD_MINIMUM_LENGTH;
import static org.apache.openmeetings.util.OpenmeetingsVariables.webAppRootKey;

import java.util.Date;

import org.apache.openmeetings.db.dao.basic.ConfigurationDao;
import org.apache.openmeetings.db.dao.basic.NavigationDao;
import org.apache.openmeetings.db.dao.label.LabelDao;
import org.apache.openmeetings.db.dao.room.RoomDao;
import org.apache.openmeetings.db.dao.room.SipDao;
import org.apache.openmeetings.db.dao.server.OAuth2Dao;
import org.apache.openmeetings.db.dao.user.GroupDao;
import org.apache.openmeetings.db.dao.user.UserDao;
import org.apache.openmeetings.db.entity.basic.Configuration;
import org.apache.openmeetings.db.entity.basic.Naviglobal;
import org.apache.openmeetings.db.entity.room.Room;
import org.apache.openmeetings.db.entity.room.Room.RoomElement;
import org.apache.openmeetings.db.entity.room.Room.Type;
import org.apache.openmeetings.db.entity.room.RoomGroup;
import org.apache.openmeetings.db.entity.server.OAuthServer;
import org.apache.openmeetings.db.entity.server.OAuthServer.RequestMethod;
import org.apache.openmeetings.db.entity.user.Group;
import org.apache.openmeetings.db.entity.user.GroupUser;
import org.apache.openmeetings.db.entity.user.User;
import org.apache.openmeetings.db.entity.user.User.Right;
import org.apache.wicket.util.string.StringValue;
import org.red5.logging.Red5LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportInitvalues {
	private static final Logger log = Red5LoggerFactory.getLogger(ImportInitvalues.class, webAppRootKey);

	@Autowired
	private ConfigurationDao cfgDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private NavigationDao navimanagement;
	@Autowired
	private SipDao sipDao;
	@Autowired
	private OAuth2Dao oauthDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private RoomDao roomDao;

	private int progress = 0;

	public int getProgress() {
		return progress;
	}

	public void loadMainMenu() {
		/*
		 * ######################## Dashboard Menu Points
		 */
		Naviglobal home = navimanagement.addGlobalStructure(1, "124", LEVEL_USER, "home", "582");
		navimanagement.addMainStructure("dashboardModuleStartScreen", null, 1, "290", LEVEL_USER, "Dashboard", home.getId(), "1450");
		navimanagement.addMainStructure("dashboardModuleCalendar", null, 2, "291", LEVEL_USER, "Calendar", home.getId(), "1451");

		/*
		 * ######################## Conference Menu Points
		 */
		Naviglobal rooms = navimanagement.addGlobalStructure(2, "792", LEVEL_USER, MENU_ROOMS_NAME, "793");
		navimanagement.addMainStructure("conferenceModuleRoomList", "publicTabButton", 1, "777", LEVEL_USER, "Public Rooms", rooms.getId(), "1506");
		navimanagement.addMainStructure("conferenceModuleRoomList", "privateTabButton", 2, "779", LEVEL_USER, "Private Rooms", rooms.getId(), "1507");
		navimanagement.addMainStructure("conferenceModuleRoomList", "myTabButton", 3, "781", LEVEL_USER, "My Rooms", rooms.getId(), "1508");

		/*
		 * ######################## Recording Menu Points
		 */
		Naviglobal rec = navimanagement.addGlobalStructure(3, "395", LEVEL_USER, "record", "583");
		navimanagement.addMainStructure("recordModule", null, 1, "395", LEVEL_USER, "Recordings", rec.getId(), "1452");

		/*
		 * ######################## Administration Menu Points
		 */
		Naviglobal admin = navimanagement.addGlobalStructure(6, "6", LEVEL_GROUP_ADMIN, "Administration Menu", "586");
		navimanagement.addMainStructure("adminModuleUser", null, 14, "125", LEVEL_GROUP_ADMIN, "Administration of Users", admin.getId(), "1454");
		navimanagement.addMainStructure("adminModuleConnections", null, 15, "597", LEVEL_ADMIN, "Aministration of Connections", admin.getId(), "1455");
		navimanagement.addMainStructure("adminModuleOrg", null, 16, "126", LEVEL_GROUP_ADMIN, "Administration of Groups", admin.getId(), "1456");
		navimanagement.addMainStructure("adminModuleRoom", null, 17, "186", LEVEL_GROUP_ADMIN, "Administration of Rooms", admin.getId(), "1457");
		navimanagement.addMainStructure("adminModuleConfiguration", null, 18, "263", LEVEL_ADMIN, "Administration of Configuration", admin.getId(), "1458");
		navimanagement.addMainStructure("adminModuleLanguages", null, 19, "348", LEVEL_ADMIN, "Administration of Languages", admin.getId(), "1459");
		navimanagement.addMainStructure("adminModuleLDAP", null, 20, "1103", LEVEL_ADMIN, "Administration of LDAP Configs", admin.getId(), "1460");
		navimanagement.addMainStructure("adminModuleOAuth", null, 21, "1571", LEVEL_ADMIN, "Administration of OAuth2 servers", admin.getId(), "1572");
		navimanagement.addMainStructure("adminModuleBackup", null, 22, "367", LEVEL_ADMIN, "Administration of Backups", admin.getId(), "1461");
		navimanagement.addMainStructure("adminModuleEmail", null, 23, "main.menu.admin.email", LEVEL_ADMIN, "Administration of Emails", admin.getId(), "main.menu.admin.email.desc");
		log.debug("MainMenu ADDED");
	}

	public void loadConfiguration(InstallationConfig cfg) {
		cfgDao.add(CONFIG_CRYPT, cfg.cryptClassName, Configuration.Type.string,
				"This Class is used for Authentification-Crypting. "
						+ "Be carefull what you do here! If you change it while "
						+ "running previous Pass of users will not be workign anymore! "
						+ "for more Information see http://openmeetings.apache.org/CustomCryptMechanism.html");

		cfgDao.add(CONFIG_REGISTER_FRONTEND, cfg.allowFrontendRegister, Configuration.Type.bool, "Is user register available on login screen");
		cfgDao.add(CONFIG_REGISTER_SOAP, "1", Configuration.Type.bool, "Is user register available via SOAP/REST");
		cfgDao.add(CONFIG_REGISTER_OAUTH, "1", Configuration.Type.bool, "Is user register available via OAuth");
		// this group_id is the Group of users who register through the frontend or SOAP
		cfgDao.add(CONFIG_DEFAULT_GROUP_ID, "1", Configuration.Type.number, "");

		cfgDao.add(CONFIG_SMTP_SERVER, cfg.smtpServer, Configuration.Type.string, "this is the smtp server to send messages");

		cfgDao.add(CONFIG_SMTP_PORT, "" + cfg.smtpPort, Configuration.Type.number, "this is the smtp server port normally 25");

		cfgDao.add(CONFIG_SMTP_SYSTEM_EMAIL, cfg.mailReferer, Configuration.Type.string, "all send e-mails by the system will have this address");

		cfgDao.add(CONFIG_SMTP_USER, cfg.mailAuthName, Configuration.Type.string, "System auth email username");

		cfgDao.add(CONFIG_SMTP_PASS, cfg.mailAuthPass, Configuration.Type.string, "System auth email password");

		cfgDao.add(CONFIG_SMTP_TLS, cfg.mailUseTls, Configuration.Type.bool, "Enable TLS 1=true, 0=false");

		cfgDao.add(CONFIG_SMTP_TIMEOUT_CON, "30000", Configuration.Type.number,
				"Socket connection timeout value in milliseconds. Default is 30 seconds (30000).");

		cfgDao.add(CONFIG_SMTP_TIMEOUT, "30000", Configuration.Type.number,
				"Socket I/O timeout value in milliseconds. Default is 30 seconds (30000).");

		cfgDao.add(CONFIG_APPLICATION_NAME, DEFAULT_APP_NAME, Configuration.Type.string, "Name of the Browser Title window");

		// "1" == "EN"
		cfgDao.add(CONFIG_DEFAULT_LANG, cfg.defaultLangId, Configuration.Type.number, "Default System Language ID see languages.xml");

		cfgDao.add(CONFIG_DOCUMENT_DPI, "" + cfg.docDpi, Configuration.Type.number,
				"dpi for conversion of PDF to images (should be an integer between 50 and  600 with a default value of 150 dpi)");

		cfgDao.add(CONFIG_DOCUMENT_QUALITY, "" + cfg.docQuality, Configuration.Type.number,
				"compression quality for conversion of PDF to images (should be an integer between 1 and 100, with a default value of 90)");

		cfgDao.add(CONFIG_PATH_IMAGEMAGIC, cfg.imageMagicPath, Configuration.Type.string, "Path to ImageMagick tools");

		cfgDao.add(CONFIG_PATH_SOX, cfg.soxPath, Configuration.Type.string, "Path To SoX-Tools");

		cfgDao.add(CONFIG_PATH_FFMPEG, cfg.ffmpegPath, Configuration.Type.string, "Path To FFMPEG");
		cfgDao.add(CONFIG_PATH_OFFICE, cfg.officePath, Configuration.Type.string,
				"The path to OpenOffice/LibreOffice (optional) please set this to the real path in case jodconverter is unable to find OpenOffice/LibreOffice installation automatically");

		cfgDao.add(CONFIG_DASHBOARD_RSS_FEED1, cfg.urlFeed, Configuration.Type.string, "Feed URL 1");

		cfgDao.add(CONFIG_DASHBOARD_RSS_FEED2, cfg.urlFeed2, Configuration.Type.string, "Feed URL 2");

		cfgDao.add(CONFIG_EMAIL_AT_REGISTER, cfg.sendEmailAtRegister, Configuration.Type.bool,
				"User get a EMail with their Account data. Values: 0(No) or 1(Yes)");

		cfgDao.add(CONFIG_EMAIL_VERIFICATION, cfg.sendEmailWithVerficationCode, Configuration.Type.bool,
				String.format("User must activate their account by clicking on the "
					+ "activation-link in the registering Email. Values: 0(No) or 1(Yes) "
					+ "It makes no sense to make this(%s) 1(Yes) while "
					+ "%s is 0(No) cause you need to send a EMail.", CONFIG_EMAIL_VERIFICATION, CONFIG_EMAIL_AT_REGISTER));

		cfgDao.add(CONFIG_APPLICATION_BASE_URL, cfg.baseUrl, Configuration.Type.string, "Base URL your OPenmeetings installation will be accessible at.");

		// ***************************************
		// ***************************************
		// SIP Integration Coniguration Values
		// ***************************************

		cfgDao.add(CONFIG_SIP_ENABLED, cfg.sipEnable, Configuration.Type.bool, "Enable to enable the red5SIP integration ");
		cfgDao.add(CONFIG_SIP_ROOM_PREFIX, cfg.sipRoomPrefix, Configuration.Type.string, "Numerical prefix for OM rooms created inside the SIP");
		cfgDao.add(CONFIG_SIP_EXTEN_CONTEXT, cfg.sipExtenContext, Configuration.Type.string, "Enable to enable the red5SIP integration ");

		// ***************************************
		// ***************************************
		// Timezone settings
		// ***************************************

		cfgDao.add(CONFIG_DEFAULT_TIMEZONE, cfg.ical_timeZone, Configuration.Type.string, "This is the default timezone if nothing is specified");

		// ***************************************
		// ***************************************
		// additional settings
		// ***************************************

		cfgDao.add(CONFIG_SCREENSHARING_QUALITY, "1", Configuration.Type.number,
				"Default selection in ScreenSharing Quality:\n 0 - bigger frame rate, no resize\n 1 - no resize\n 2 - size == 1/2 of selected area\n 3 - size == 3/8 of selected area");

		cfgDao.add(CONFIG_SCREENSHARING_FPS, "10", Configuration.Type.number, "Default selection in ScreenSharing FPS");
		cfgDao.add(CONFIG_SCREENSHARING_FPS_SHOW, "true", Configuration.Type.bool, "Is screensharing FPS should be displayed or not (true/false)");
		cfgDao.add(CONFIG_SCREENSHARING_ALLOW_REMOTE, "true", Configuration.Type.bool, "Is remote control will be enabled while screensharing. Allowing remote control will be not possible in case it is set to 'false' (true/false)");

		cfgDao.add(CONFIG_DASHBOARD_SHOW_MYROOMS, "true", Configuration.Type.bool, "Show My Rooms Tab");

		cfgDao.add(CONFIG_DASHBOARD_SHOW_CHAT, "true", Configuration.Type.bool, "Show Chat Tab");

		cfgDao.add(CONFIG_DASHBOARD_SHOW_RSS, "false", Configuration.Type.bool, "Show RSS Tab");

		cfgDao.add(CONFIG_MAX_UPLOAD_SIZE, "" + DEFAULT_MAX_UPLOAD_SIZE, Configuration.Type.number,
				"Maximum size of upload file (bytes)"); // defaults to 100MB

		cfgDao.add(CONFIG_APPOINTMENT_REMINDER_MINUTES, "15", Configuration.Type.number,
				"The number of minutes before reminder emails are send. Set to 0 to disable reminder emails");

		cfgDao.add(CONFIG_LOGIN_MIN_LENGTH, "" + USER_LOGIN_MINIMUM_LENGTH, Configuration.Type.number,
				"Number of chars needed in a user login");

		cfgDao.add(CONFIG_PASS_MIN_LENGTH, "" + USER_PASSWORD_MINIMUM_LENGTH, Configuration.Type.number,
				"Number of chars needed in a user password");

		cfgDao.add(CONFIG_CALENDAR_ROOM_CAPACITY, "50", Configuration.Type.number,
				"Default number of participants conference room created via calendar");

		cfgDao.add(CONFIG_KEYCODE_ARRANGE, "119", Configuration.Type.number
				, "A hot key code for arrange video windows functionality. Should be used with Shift key. (Keycode 119 is F8)");
		cfgDao.add(CONFIG_KEYCODE_EXCLUSIVE, "123", Configuration.Type.number
				, "A hot key code for the 'give exclusive audio' functionality. Should be used with Shift key. (Keycode 123 is F12)");
		cfgDao.add(CONFIG_KEYCODE_MUTE, "118", Configuration.Type.number
				, "A hot key code for the 'mute/unmute audio' functionality. Should be used with Shift key. (Keycode 118 is F7)");

		// system-wide ldap params
		cfgDao.add(CONFIG_DEFAULT_LDAP_ID, "0", Configuration.Type.number, "Ldap domain selected by default in the login screen");

		// set inviter's email address as ReplyTo in email invitations
		cfgDao.add(CONFIG_REPLY_TO_ORGANIZER, cfg.replyToOrganizer, Configuration.Type.bool,
				"Set inviter's email address as ReplyTo in email invitations (1 == set, 0 == NOT set)");

		cfgDao.add(CONFIG_DEFAULT_LANDING_ZONE, "user/dashboard", Configuration.Type.string
				, "Area to be shown to the user after login. Possible values are: "
					+ "user/dashboard, user/calendar, user/record, rooms/my, rooms/group, rooms/public, admin/user, admin/connection"
					+ ", admin/group, admin/room, admin/config, admin/lang, admin/ldap, admin/backup, admin/server, admin/oauth2");

		// oauth2 params
		cfgDao.add(CONFIG_IGNORE_BAD_SSL, "false", Configuration.Type.bool,
				"Set \"yes\" or \"no\" to enable/disable ssl certifications checking for OAuth2");

		cfgDao.add(CONFIG_REDIRECT_URL_FOR_EXTERNAL, "", Configuration.Type.string,
				"Users entered the room via invitationHash or secureHash will be redirected to this URL on connection lost");
		cfgDao.add(CONFIG_CALENDAR_FIRST_DAY, "0", Configuration.Type.number, "The day that each week begins. The value must be a number that represents the day of the week. Sunday=0, Monday=1, Tuesday=2, etc.");
		cfgDao.add(CONFIG_GOOGLE_ANALYTICS_CODE, null, Configuration.Type.string, "Code for Google Analytics");
		cfgDao.add(CONFIG_FLASH_SECURE, "false", Configuration.Type.bool, "Wether it should try to connect to rtmps first or not\nValid values: yes / no");
		cfgDao.add(CONFIG_FLASH_SECURE_PROXY, "none", Configuration.Type.string, "The setting for the NetConnection default settings is 'none'\n set to value 'best' if you are trying to use rtmp over native SSL");
		cfgDao.add(CONFIG_FLASH_VIDEO_CODEC, "h263", Configuration.Type.string, "Camera codecType, possible values: 'h263', 'h264'");
		cfgDao.add(CONFIG_FLASH_VIDEO_FPS, "30", Configuration.Type.number, "Camera FPS, should be positive number in range (0, 60]");
		cfgDao.add(CONFIG_FLASH_VIDEO_BANDWIDTH, "0", Configuration.Type.number, "An integer that specifies the maximum amount of bandwidth that the current outgoing video feed can use, in bytes per second. To specify that Flash video can use as much bandwidth as needed to maintain the value of frameQuality, pass 0 for bandwidth.");
		cfgDao.add(CONFIG_FLASH_CAM_QUALITY, "90", Configuration.Type.number, "An integer that specifies the required level of picture quality, as determined by the amount of compression being applied to each video frame. Acceptable values range from 1 (lowest quality, maximum compression) to 100 (highest quality, no compression). To specify that picture quality can vary as needed to avoid exceeding bandwidth, pass 0 for quality.");
		cfgDao.add(CONFIG_FLASH_MIC_RATE, "22", Configuration.Type.number, "The rate at which the microphone should capture sound, in kHz. Acceptable values are 5, 8, 11, 22, and 44. The default value is 22 kHz if your sound capture device supports this value.");
		cfgDao.add(CONFIG_FLASH_ECHO_PATH, "128", Configuration.Type.number, "Specifies the echo path length (in milliseconds). A longer echo path means better echo cancellation but also introduces longer delays and requires more processing power. The default value is 128; the only other possible value is 256. To disable AEC please specify 0.");
		cfgDao.add(CONFIG_HEADER_XFRAME, HEADER_XFRAME_SAMEORIGIN, Configuration.Type.string, "Value for 'X-Frame-Options' header (default: DENY), more info: https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options");
		cfgDao.add(CONFIG_HEADER_CSP, HEADER_CSP_SELF, Configuration.Type.string, "Value for 'Content-Security-Policy' header (default: default-src 'self'; style-src 'self' 'unsafe-inline'; script-src 'self' 'unsafe-inline' 'unsafe-eval';), have to be modified to enable Google analytics site: https://content-security-policy.com/");
		cfgDao.add(CONFIG_EXT_PROCESS_TTL, "" + EXT_PROCESS_TTL, Configuration.Type.number, String.format("Time to live in minutes for external processes such as conversion via ffmpeg (default %s minutes)", EXT_PROCESS_TTL));
		log.debug("Configurations ADDED");
	}

	private Room createRoom(String name, Room.Type type, long capacity, boolean isPublic, Long groupId) {
		Room r = new Room();
		r.setName(name);
		r.setComment("");
		r.setInserted(new Date());
		r.setNumberOfPartizipants(capacity);
		r.setType(type);
		r.setIspublic(isPublic);
		r.setAllowUserQuestions(true);
		r.setAudioOnly(false);

		r.setAppointment(false);

		r.setDemoRoom(false);
		r.setDemoTime(null);

		r.hide(RoomElement.MicrophoneStatus);
		r.setModerated(false);

		r.setDeleted(false);

		r.setClosed(false);
		r.setRedirectURL(null);

		r.setOwnerId(null);

		r.setWaitForRecording(false);
		r.setAllowRecording(true);

		if (groupId != null) {
			RoomGroup ro = new RoomGroup();
			ro.setRoom(r);
			ro.setGroup(groupDao.get(groupId));
			ro.setInserted(new Date());
			r.getRoomGroups().add(ro);
		}
		r = roomDao.update(r, null);
		return r;
	}

	public void loadDefaultRooms(boolean createRooms, long langId) {
		if (createRooms) {
			createRoom(LabelDao.getString("install.room.public.interview", langId), Type.interview, 16L, true, null);
			createRoom(LabelDao.getString("install.room.public.conference", langId), Type.conference, 32L, true, null);
			Room r = createRoom(LabelDao.getString("install.room.public.video.only", langId), Type.conference, 32L, true, null);
			r.hide(RoomElement.Whiteboard);
			roomDao.update(r, null);
			createRoom(LabelDao.getString("install.room.public.video.wb", langId), Type.conference, 32L, true, null);
			createRoom(LabelDao.getString("install.room.public.presentation", langId), Type.presentation, 100L, true, null);
			r = createRoom(LabelDao.getString("install.room.presentation.micro", langId), Type.presentation, 100L, true, null);
			r.getHiddenElements().clear();
			roomDao.update(r, null);

			r = createRoom(LabelDao.getString("install.room.conference.micro", langId), Type.conference, 32L, true, null);
			r.getHiddenElements().clear();
			roomDao.update(r, null);

			createRoom(LabelDao.getString("install.room.private.conference", langId), Type.conference, 32L, false, 1L);
		}
	}

	public void loadInitUserAndGroup(InstallationConfig cfg) throws Exception {
		// Add default group
		Group org = new Group();
		org.setName(cfg.group);
		org.setInsertedby(1L);
		org.setDeleted(false);
		org.setInserted(new Date());
		org = groupDao.update(org, null);

		User u = userDao.getNewUserInstance(null);
		u.setType(User.Type.user);
		u.getRights().add(Right.Admin);
		u.getRights().add(Right.Soap);
		u.setLogin(cfg.username);
		u.setFirstname("firstname");
		u.setLastname("lastname");
		u.getAddress().setEmail(cfg.email);
		u.getGroupUsers().add(new GroupUser(org, u));

		u = userDao.update(u, cfg.getPassword(), -1L);

		log.debug("Installation - User Added user-Id " + u.getId());

		if (u.getId() == null) {
			throw new Exception("Unable to add user");
		}
	}

	public void loadInitialOAuthServers() {
		// Yandex
		OAuthServer yandexServer = new OAuthServer();
		yandexServer.setName("Yandex");
		yandexServer.setIconUrl("http://yandex.st/morda-logo/i/favicon.ico");
		yandexServer.setClientId("<put your client_id>");
		yandexServer.setClientSecret("<put your client_secret>");
		yandexServer.setEnabled(false);
		yandexServer.setRequestInfoUrl("https://login.yandex.ru/info?format=json&oauth_token={$access_token}");
		yandexServer.setRequestTokenUrl("https://oauth.yandex.ru/token");
		yandexServer.setRequestKeyUrl("https://oauth.yandex.ru/authorize?response_type=code&client_id={$client_id}");
		yandexServer.setRequestTokenAttributes("grant_type=authorization_code&code={$code}&client_id={$client_id}&client_secret={$client_secret}");
		yandexServer.setRequestTokenMethod(RequestMethod.POST);
		yandexServer.setLoginParamName("login");
		yandexServer.setEmailParamName("default_email");
		yandexServer.setFirstnameParamName("first_name");
		yandexServer.setLastnameParamName("last_name");
		oauthDao.update(yandexServer, null);

		// Google
		OAuthServer googleServer = new OAuthServer();
		googleServer.setName("Google");
		googleServer.setIconUrl("https://www.google.ru/images/google_favicon_128.png");
		googleServer.setEnabled(false);
		googleServer.setClientId("<put your client_id>");
		googleServer.setClientSecret("<put your client_secret>");
		googleServer.setRequestKeyUrl("https://accounts.google.com/o/oauth2/auth?redirect_uri={$redirect_uri}&response_type=code&client_id={$client_id}"
				+ "&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile");
		googleServer.setRequestTokenUrl("https://accounts.google.com/o/oauth2/token");
		googleServer.setRequestTokenMethod(RequestMethod.POST);
		googleServer.setRequestTokenAttributes("code={$code}&client_id={$client_id}&client_secret={$client_secret}&redirect_uri={$redirect_uri}&grant_type=authorization_code");
		googleServer.setRequestInfoUrl("https://www.googleapis.com/oauth2/v1/userinfo?access_token={$access_token}");
		googleServer.setLoginParamName("email");
		googleServer.setEmailParamName("email");
		googleServer.setFirstnameParamName("given_name");
		googleServer.setLastnameParamName("family_name");
		oauthDao.update(googleServer, null);

		// Facebook
		OAuthServer facebookServer = new OAuthServer();
		facebookServer.setName("Facebook");
		facebookServer.setIconUrl("https://www.facebook.com/images/fb_icon_325x325.png");
		facebookServer.setEnabled(false);
		facebookServer.setClientId("<put your client_id>");
		facebookServer.setClientSecret("<put your client_secret>");
		facebookServer.setRequestKeyUrl("https://www.facebook.com/dialog/oauth?client_id={$client_id}&redirect_uri={$redirect_uri}&scope=email");
		facebookServer.setRequestTokenUrl("https://graph.facebook.com/v2.3/oauth/access_token");
		facebookServer.setRequestTokenMethod(RequestMethod.POST);
		facebookServer.setRequestTokenAttributes("client_id={$client_id}&redirect_uri={$redirect_uri}&client_secret={$client_secret}&code={$code}");
		facebookServer.setRequestInfoUrl("https://graph.facebook.com/me?access_token={$access_token}&fields=id,first_name,last_name,email");
		facebookServer.setLoginParamName("id");
		facebookServer.setEmailParamName("email");
		facebookServer.setFirstnameParamName("first_name");
		facebookServer.setLastnameParamName("last_name");
		oauthDao.update(facebookServer, null);
	}

	// ------------------------------------------------------------------------------

	public void loadSystem(InstallationConfig cfg, boolean force) {
		// FIXME dummy check if installation was performed before
		if (!force && userDao.count() > 0) {
			log.debug("System contains users, no need to install data one more time.");
		}
		sipDao.delete();
		progress = 16;
		loadMainMenu();
		progress = 32;
		loadConfiguration(cfg);
		progress = 48;
		loadInitialOAuthServers();
		progress = 64;
	}

	public void loadAll(InstallationConfig cfg, boolean force) throws Exception {
		// FIXME dummy check if installation was performed before
		if (!force && userDao.count() > 0) {
			log.debug("System contains users, no need to install data one more time.");
			return;
		}
		loadSystem(cfg, force);
		loadInitUserAndGroup(cfg);
		progress = 80;

		loadDefaultRooms("1".equals(cfg.createDefaultRooms), StringValue.valueOf(cfg.defaultLangId).toLong(1L));
		progress = 100;
	}
}
