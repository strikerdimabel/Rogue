package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogUtil {
	
	private static final File FILE = new File("server.log");
	private static final Map<String, Logger> loggers = new HashMap<>();
	
	public static Logger getLogger(Class<?> tClass) {
		return getLogger(tClass.getName());
	}
	
	public static Logger getLogger(String name) {
		Logger logger = loggers.get(name);
		if (logger == null) {
			logger = Logger.getLogger(name);	
			FileLogHandler newHandler = FileLogHandler.getFileLogHandler(FILE);
			logger.addHandler(newHandler);
			loggers.put(name, logger);
		}
		return logger;
	}
	
}

class FileLogHandler extends Handler {

	private static Map<String, FileLogHandler> handlers = new HashMap<>(); 
	private PrintWriter pw;
	
	private FileLogHandler(File file) {
		try {
			pw = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static FileLogHandler getFileLogHandler(File file) {
		FileLogHandler handler;
		synchronized (handlers) {
			handler = handlers.get(file.getAbsolutePath());
			if (handler == null) {
				handler = new FileLogHandler(file);
				handlers.put(file.getAbsolutePath(), handler);
			}		
		}
		return handler;
	}

	@Override
	public void publish(LogRecord record) {
		pw.print(record.getLevel());
		pw.print("  ");
		pw.print(new Date(record.getMillis()));
		pw.print("  ");
		pw.print(record.getSourceClassName());
		pw.print(".");
		pw.print(record.getSourceMethodName());
		pw.print("()  ");
		pw.print(record.getMessage());
		pw.print("\n");
		if (record.getThrown() != null) {
			record.getThrown().printStackTrace(pw);
		}
	}

	@Override
	public void flush() {
		pw.flush();
	}

	@Override
	public void close() throws SecurityException {
		pw.close();
	}
	
}
