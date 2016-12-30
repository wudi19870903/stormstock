package stormstock.fw.base;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stormstock.fw.base.BAutoSync.BSyncObj;

public class BLog {

	public static void config_setLogDir(String dirName)
	{
		s_strLogDirName = dirName;
	}
	public static void config_setTag(String tag, boolean enable)
	{
		s_tagMap.put(tag, enable);
	}
	public static void config_output()
	{
		outputConsole("BLog.config_output ----------------->>>>>> begin\n");
		for (Map.Entry<String, Boolean> entry : s_tagMap.entrySet()) {
			String tag = entry.getKey();
			Boolean enable = entry.getValue();
			outputConsole("tag[%s] enable[%b]\n", tag, enable);
		}
		outputConsole("BLog.config_output ----------------->>>>>> end\n");
	}
	
	public static void error(String target, String format, Object... args)
	{
		String logstr = String.format(format, args);
		output("ERROR", "(%s) %s", target, logstr);
	}
	
	public static void output(String target, String format, Object... args)
	{
		if(!s_tagMap.containsKey(target) || s_tagMap.get(target) == false)
		{
				return;
		}
		
		String logstr = String.format(format, args);
		outputConsole("[%s] %s", target, logstr);
		
		File cDir = new File(s_strLogDirName);  
		if (!cDir.exists()  && !cDir.isDirectory())      
		{       
		    cDir.mkdir();    
		}
		File cfile =new File(s_strLogDirName + "\\" + s_strLogName);
		try
		{
			FileOutputStream cOutputStream = new FileOutputStream(cfile, true);
			cOutputStream.write(logstr.getBytes());
			cOutputStream.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception:" + e.getMessage()); 
		}
	}
	
	private static void outputConsole(String format, Object... args)
	{
		String logstr = String.format(format, args);
		s_fmt.format("%s", logstr);
	}
	static private Formatter s_fmt = new Formatter(System.out);
	static private String s_strLogName = "default.log";
	static private String s_strLogDirName = BPath.getOutputDir();
	static private Map<String, Boolean> s_tagMap = new HashMap<String, Boolean>() {
		{
			put("TEST", true);
			put("ERROR", true);
		}
	};
}