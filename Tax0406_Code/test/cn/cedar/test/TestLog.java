package cn.cedar.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	@Test
	public void test(){
		Log log = LogFactory.getLog(getClass());
		log.debug("Debug������־");
		log.info("info������־");
		log.warn("warn������־");
		log.error("error������־");
		log.fatal("fatal������־");
	}
}
