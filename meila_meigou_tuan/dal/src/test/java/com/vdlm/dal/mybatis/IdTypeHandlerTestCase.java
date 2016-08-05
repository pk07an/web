package com.vdlm.dal.mybatis;

import java.util.Date;

import com.vdlm.dal.type.LogisticsCompanyInfo;

import junit.framework.TestCase;

public class IdTypeHandlerTestCase extends TestCase {
    public void testIdGen() {
        IdTypeHandler idTypeHandler = new IdTypeHandler();
        System.out.println(idTypeHandler.decode("8rp9x7jp"));
        // System.out.println(idTypeHandler.encode(10));
        // System.out.println(idTypeHandler.encode(2446));
        // System.out.println();
        // System.out.println();
        // System.out.println(idTypeHandler.encode(355));
        // System.out.println(idTypeHandler.encode(100071));
        // System.out.println("\u6210\u529f");
        //// 3673622
        //// 2329802
        //// 3344814
        //// 3256739
        //// 1003066
        //
        //// 2479370
        //// 3673622
        //// 3344814
        System.out.println(idTypeHandler.encode(3090));
        // System.out.println(idTypeHandler.encode(2965));
        // System.out.println(idTypeHandler.encode(2946));
        // System.out.println(idTypeHandler.encode(2961));
        // System.out.println(idTypeHandler.encode(2959));
        // System.out.println(idTypeHandler.encode(2959));
        // //
        // System.out.println(idTypeHandler.encode(2637));
        // System.out.println(idTypeHandler.encode(2944));
        // System.out.println(idTypeHandler.encode(2945));
        // System.out.println(idTypeHandler.encode(3344814));
        Integer i = null;
        System.out.println(i.intValue());
        //
        //
        //
        // System.out.println(idTypeHandler.decode("ng5e"));
        // System.out.println(idTypeHandler.decode("n9ua"));
        // System.out.println(idTypeHandler.decode("27gjz"));
        // System.out.println(idTypeHandler.decode("1w80e"));
        // System.out.println(idTypeHandler.decode("1vs9i"));
        // System.out.println(new Date(1442222178));
        System.out.println(LogisticsCompanyInfo.getCompany_nameByCode("aa"));
        System.out.println(idTypeHandler.encode(2965));
        System.out.println(idTypeHandler.encode(2946));
        System.out.println(idTypeHandler.encode(2961));
        System.out.println(idTypeHandler.encode(2959));
        System.out.println(idTypeHandler.encode(2959));
        //
        System.out.println(idTypeHandler.encode(2637));
        System.out.println(idTypeHandler.encode(2944));
        System.out.println(idTypeHandler.encode(2945));
        System.out.println(idTypeHandler.encode(2946));

        System.out.println(idTypeHandler.decode("aj11x60e"));
        System.out.println(idTypeHandler.decode("ol8a"));
        System.out.println(idTypeHandler.decode("dj3d"));
        System.out.println(idTypeHandler.decode("1w80e"));
        System.out.println(idTypeHandler.decode("1vs9i"));
    }
}
