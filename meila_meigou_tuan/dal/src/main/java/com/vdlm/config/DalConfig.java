package com.vdlm.config;

import javax.sql.DataSource;

import com.vdlm.dal.mapper.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;

import com.vdlm.dal.dao.MeiLaCartDao;
import com.vdlm.dal.dao.MeiLaOrderDao;
import com.vdlm.dal.dao.MeiLaProductDao;
import com.vdlm.dal.dao.MeiLaSkuDao;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.mybatis.ObjectRangeHandler;
import com.vdlm.dal.mybatis.PromotionActionTypeHandler;

@Configuration
@ImportResource({"classpath:/META-INF/applicationContext-dal.xml","classpath:/META-INF/applicationContext-dal-slave.xml"})
public class DalConfig {
	
	@Value("classpath:config/MapperConfig.xml")
	Resource mybatisMapperConfig;

	@Autowired
	DataSource dataSource;

	// @Autowired
	// Environment env;

	@Bean
	public AccountMapper accountMapper() throws Exception {
		return newMapperFactoryBean(AccountMapper.class).getObject();
	}
	
	@Bean
	public DealMapper dealMapper() throws Exception {
		return newMapperFactoryBean(DealMapper.class).getObject();
	}
	
	@Bean
	public DealLogMapper dealLogMapper() throws Exception {
		return newMapperFactoryBean(DealLogMapper.class).getObject();
	}

	@Bean
	public AddressMapper addressMapper() throws Exception {
		return newMapperFactoryBean(AddressMapper.class).getObject();
	}

	@Bean
	public CartItemMapper cartItemMapper() throws Exception {
		return newMapperFactoryBean(CartItemMapper.class).getObject();
	}
	
	@Bean
	public CashierItemMapper cashierItemMapper() throws Exception {
		return newMapperFactoryBean(CashierItemMapper.class).getObject();
	}

	@Bean
	public OrderAddressMapper orderAddressMapper() throws Exception {
		return newMapperFactoryBean(OrderAddressMapper.class).getObject();
	}

	@Bean
	public OrderItemMapper orderItemMapper() throws Exception {
		return newMapperFactoryBean(OrderItemMapper.class).getObject();
	}

	@Bean
	public OrderMapper orderMapper() throws Exception {
		return newMapperFactoryBean(OrderMapper.class).getObject();
	}
	
	@Bean
	public OrderItemCommentMapper orderItemCommentMapper() throws Exception {
		return newMapperFactoryBean(OrderItemCommentMapper.class).getObject();
	}
	
	@Bean
	public ActivityOrderMapper activityOrderMapper() throws Exception {
		return newMapperFactoryBean(ActivityOrderMapper.class).getObject();
	}

	@Bean
	public ProductMapper productMapper() throws Exception {
		return newMapperFactoryBean(ProductMapper.class).getObject();
	}

	// add by luojy 20150708
	@Bean
	public ProductDescMapper productDescMapper() throws Exception {
		return newMapperFactoryBean(ProductDescMapper.class).getObject();
	}

	@Bean
	public ProductInfoMapper productInfoMapper() throws Exception {
		return newMapperFactoryBean(ProductInfoMapper.class).getObject();
	}

    // add by reese 2015/7/15
    @Bean
	public ProductUpdateLogMapper productUpdateLogMapper() throws Exception {
		return newMapperFactoryBean(ProductUpdateLogMapper.class).getObject();
	}
	
	@Bean
	public ShopMapper shopMapper() throws Exception {
		return newMapperFactoryBean(ShopMapper.class).getObject();
	}
	
	@Bean
	public FragmentMapper fragmentMapper() throws Exception {
		return newMapperFactoryBean(FragmentMapper.class).getObject();
	}
	
	@Bean 
	public FragmentImageMapper fragmentImageMapper() throws Exception {
		return newMapperFactoryBean(FragmentImageMapper.class).getObject();
	}
	
	@Bean
	public ProductFragmentMapper productFragmentMapper() throws Exception {
		return newMapperFactoryBean(ProductFragmentMapper.class).getObject();
	}

	@Bean
	public SkuMapper skuMapper() throws Exception {
		return newMapperFactoryBean(SkuMapper.class).getObject();
	}
	
	@Bean
	public SkuMappingMapper skuMappingMapper() throws Exception {
		return newMapperFactoryBean(SkuMappingMapper.class).getObject();
	}

	@Bean
	public ZoneMapper zoneMapper() throws Exception {
		return newMapperFactoryBean(ZoneMapper.class).getObject();
	}

	@Bean
	public AppVersionMapper appVersionMapper() throws Exception {
		return newMapperFactoryBean(AppVersionMapper.class).getObject();
	}

	@Bean
	public UserMapper userMapper() throws Exception {
		return newMapperFactoryBean(UserMapper.class).getObject();
	}
	
	@Bean
	public UserAlipayMapper userAlipayMapper() throws Exception {
		return newMapperFactoryBean(UserAlipayMapper.class).getObject();
	}

	@Bean
	public ImageMapper imageMapper() throws Exception {
		return newMapperFactoryBean(ImageMapper.class).getObject();
	}

	@Bean
	public FeedbackMapper feedbackMapper() throws Exception {
		return newMapperFactoryBean(FeedbackMapper.class).getObject();
	}
	
	@Bean
	public VoucherMapper voucherMapper() throws Exception {
		return newMapperFactoryBean(VoucherMapper.class).getObject();
	}
	
	@Bean
	public PromotionModelMapper promotionModelMapper() throws Exception {
		return newMapperFactoryBean(PromotionModelMapper.class).getObject();
	}

	@Bean
	public TagMapper tagMapper() throws Exception {
		return newMapperFactoryBean(TagMapper.class).getObject();
	}

	@Bean
	public ProductTagMapper productTagMapper() throws Exception {
		return newMapperFactoryBean(ProductTagMapper.class).getObject();
	}

	@Bean
	public ProductImageMapper productImageMapper() throws Exception {
		return newMapperFactoryBean(ProductImageMapper.class).getObject();
	}
	
	@Bean
	public TinyUrlMapper tinyUrlMapper() throws Exception {
		return newMapperFactoryBean(TinyUrlMapper.class).getObject();
	}
	
	@Bean
	public PaymentMapper paymentMapper() throws Exception {
		return newMapperFactoryBean(PaymentMapper.class).getObject();
	}
	
	@Bean
	public ShopAccessMapper shopAccessMapper() throws Exception {
		return newMapperFactoryBean(ShopAccessMapper.class).getObject();
	}
	
	@Bean
	public AccessReportMapper accessReportMapper() throws Exception {
		return newMapperFactoryBean(AccessReportMapper.class).getObject();
	}
	
	@Bean
	public MessageMapper messageMapper() throws Exception {
		return newMapperFactoryBean(MessageMapper.class).getObject();
	}
	
	@Bean
	public UserMessageMapper userMessageMapper() throws Exception {
		return newMapperFactoryBean(UserMessageMapper.class).getObject();
	}

	@Bean
	public UserBankMapper userBankMapper() throws Exception {
		return newMapperFactoryBean(UserBankMapper.class).getObject();
	}
	
	@Bean
	public WithdrawApplyMapper withdrawApplyMapper() throws Exception {
		return newMapperFactoryBean(WithdrawApplyMapper.class).getObject();
	}
	
	@Bean
	public PushMessageMapper pushMessageMapper() throws Exception {
		return newMapperFactoryBean(PushMessageMapper.class).getObject();
	}
	
	@Bean
	public PersonnelMapper personnelMapper() throws Exception {
		return newMapperFactoryBean(PersonnelMapper.class).getObject();
	}

	@Bean
	public SmsMessageMapper smsMessageMapper() throws Exception {
		return newMapperFactoryBean(SmsMessageMapper.class).getObject();
	}
	
	@Bean
	public SubAccountLogMapper subAccountLogMapper() throws Exception {
		return newMapperFactoryBean(SubAccountLogMapper.class).getObject();
	}
	
	@Bean
	public SubAccountMapper subAccountMapper() throws Exception {
		return newMapperFactoryBean(SubAccountMapper.class).getObject();
	}
	
	@Bean
	public SubAccountSnapshotMapper subAccountSnapshotMapper() throws Exception {
		return newMapperFactoryBean(SubAccountSnapshotMapper.class).getObject();
	}
	
	@Bean
	public OutpayMapper outpayMapper() throws Exception {
		return newMapperFactoryBean(OutpayMapper.class).getObject();
	}
	
	@Bean
	public PayRequestMapper payRequestMapper() throws Exception {
		return newMapperFactoryBean(PayRequestMapper.class).getObject();
	}
	
	@Bean
	public CommissionMapper commissionMapper() throws Exception {
		return newMapperFactoryBean(CommissionMapper.class).getObject();
	}
	
	@Bean
	public ActivityMapper activityMapper() throws Exception {
		return newMapperFactoryBean(ActivityMapper.class).getObject();
	}
	
	@Bean
	public CategoryMapper categoryMapper() throws Exception {
		return newMapperFactoryBean(CategoryMapper.class).getObject();
	}

	@Bean
	public TermMapper termMapper() throws Exception {
		return newMapperFactoryBean(TermMapper.class).getObject();
	}
	
	@Bean
	public TermRelationshipMapper termRelationshipMapper() throws Exception {
		return newMapperFactoryBean(TermRelationshipMapper.class).getObject();
	}
	
	@Bean
	public PosterMapper posterMapper() throws Exception {
		return newMapperFactoryBean(PosterMapper.class).getObject();
	}
	
	@Bean
	public PayBankMapper payBankMapper() throws Exception {
		return newMapperFactoryBean(PayBankMapper.class).getObject();
	}

	@Bean
	public PosterTagMapper posterTagMapper() throws Exception {
	    return newMapperFactoryBean(PosterTagMapper.class).getObject();
	}

	@Bean
	public ShopStyleMapper shopStyleMapper() throws Exception {
		return newMapperFactoryBean(ShopStyleMapper.class).getObject();
	}
	
	@Bean
	public OutpayAgreementMapper outpayAgreementMapper() throws Exception {
	    return newMapperFactoryBean(OutpayAgreementMapper.class).getObject();
	}
	
	@Bean
	public CustomerServiceMapper customerServiceMapper() throws Exception {
		return newMapperFactoryBean(CustomerServiceMapper.class).getObject();
	}
	
	@Bean
	public PromotionMapper promotionMapper() throws Exception {
	    return newMapperFactoryBean(PromotionMapper.class).getObject();
	}
	
	@Bean
	public ProdSyncMapper prodSyncMapper() throws Exception {
	    return newMapperFactoryBean(ProdSyncMapper.class).getObject();
	}
	
	@Bean
	public ApiVisitorLogMapper apiVisitorLogMapper() throws Exception {
		return newMapperFactoryBean(ApiVisitorLogMapper.class).getObject();
	}
	
	@Bean
	public UserSigninLogMapper userSigninLogMapper() throws Exception {
		return newMapperFactoryBean(UserSigninLogMapper.class).getObject();
	}

	@Bean
	public CouponMapper couponMapper() throws Exception {
	    return newMapperFactoryBean(CouponMapper.class).getObject();
	}
	
	@Bean
	public CouponActivityMapper couponActivityMapper() throws Exception {
	    return newMapperFactoryBean(CouponActivityMapper.class).getObject();
	}
	
	@Bean
    public OrderMessageMapper orderMessageMapper() throws Exception {
        return newMapperFactoryBean(OrderMessageMapper.class).getObject();
    }
	
	@Bean
    public SmsSendRecordMapper smsSendRecordMapper() throws Exception {
        return newMapperFactoryBean(SmsSendRecordMapper.class).getObject();
    }
	
	@Bean
    public SmsTplMapper smsTplMapper() throws Exception {
        return newMapperFactoryBean(SmsTplMapper.class).getObject();
    }
	
	@Bean
    public SmsVarTplMapper smsVarTplMapper() throws Exception {
        return newMapperFactoryBean(SmsVarTplMapper.class).getObject();
    }
	
	@Bean
    public CampaignProductMapper campaignProductMapper() throws Exception {
        return newMapperFactoryBean(CampaignProductMapper.class).getObject();
    }
	
	@Bean
    public ActivityTicketMapper activityTicketMapper() throws Exception {
        return newMapperFactoryBean(ActivityTicketMapper.class).getObject();
    }
	
	@Bean
    public ActivitySPMapper activitySPMapper() throws Exception {
        return newMapperFactoryBean(ActivitySPMapper.class).getObject();
    }
	
	@Bean
    public PostAgeSetMapper postAgeSetMapper() throws Exception {
        return newMapperFactoryBean(PostAgeSetMapper.class).getObject();
    }
	
	@Bean
    public OrderRefundMapper orderRefundMapper() throws Exception {
        return newMapperFactoryBean(OrderRefundMapper.class).getObject();
    }
	
	@Bean
    public OrderRefundAttachMapper orderRefundAttachMapper() throws Exception {
        return newMapperFactoryBean(OrderRefundAttachMapper.class).getObject();
    }
	 @Bean
    public OrderExtMapper orderExtMapper() throws Exception {
        return newMapperFactoryBean(OrderExtMapper.class).getObject();
    }
	@Bean
    public HelperMessageMapper helperMessageMapper() throws Exception {
        return newMapperFactoryBean(HelperMessageMapper.class).getObject();
    }
    @Bean
    public MeiLaCartDao meiLaCartDao() throws Exception{
        return newMapperFactoryBean(MeiLaCartDao.class).getObject();
    }
    @Bean
    public MeiLaSkuDao meiLaSkuDao() throws Exception{
        return newMapperFactoryBean(MeiLaSkuDao.class).getObject();
    }
    @Bean
    public MeiLaOrderDao getMeiLaOrderDao() throws Exception{
        return newMapperFactoryBean(MeiLaOrderDao.class).getObject();
    }
    @Bean
    public MeiLaProductDao getMeiLaProductDao() throws Exception{
        return newMapperFactoryBean(MeiLaProductDao.class).getObject();
    }
    @Bean
    public OrderItemPromotionMapper getOrderItemPromotionMapper() throws Exception{
        return newMapperFactoryBean(OrderItemPromotionMapper.class).getObject();
    }
    @Bean
    public UserCouponMapper getUserCouponMapper() throws Exception{
        return newMapperFactoryBean(UserCouponMapper.class).getObject();
    }
    @Bean
    public BizConfigMapper getBizConfigMapper() throws Exception{
        return newMapperFactoryBean(BizConfigMapper.class).getObject();
    }
    @Bean
    public PaymentRequestLogsMapper getPaymentRequestLogsMapper() throws Exception{
        return newMapperFactoryBean(PaymentRequestLogsMapper.class).getObject();
    }
	<T> MapperFactoryBean<T> newMapperFactoryBean(Class<T> clazz) throws Exception {
		MapperFactoryBean<T> b = new MapperFactoryBean<T>();
		b.setMapperInterface(clazz);
		b.setSqlSessionFactory(sqlSessionFactory());
		return b;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setConfigLocation(mybatisMapperConfig);
		fb.setDataSource(dataSource);
		// env.acceptsProfiles("prod") ? IdTypeHandler.class : IdTypeNullHandler.class
		fb.setTypeAliases(new Class<?>[] { IdTypeHandler.class, ObjectRangeHandler.class, PromotionActionTypeHandler.class });

		return fb.getObject();
	} 
	
	@Bean
    public PromotionProTagMapper promotionProTagMapper() throws Exception {
        return newMapperFactoryBean(PromotionProTagMapper.class).getObject();
    }
		
	@Bean
    public PromotionTagMapper promotionTagMapper() throws Exception {
        return newMapperFactoryBean(PromotionTagMapper.class).getObject();
    }
	
	@Bean
	public ShopExtMapper shopExtMapper() throws Exception {
		return newMapperFactoryBean(ShopExtMapper.class).getObject();
	}

	@Bean
	public RoleMapper roleMapper() throws Exception {
		return newMapperFactoryBean(RoleMapper.class).getObject();
	}
	
	@Bean
	public OrderRefundApplyMapper orderRefundApplyMapper() throws Exception {
		return newMapperFactoryBean(OrderRefundApplyMapper.class).getObject();
	}

	@Bean
	public ArrivedNoticeMapper arrivedNoticeMapper() throws Exception {
		return newMapperFactoryBean(ArrivedNoticeMapper.class).getObject();
	}

	@Bean
	public OmsMonitorMapper OmsMonitorMapper() throws Exception {
		return newMapperFactoryBean(OmsMonitorMapper.class).getObject();
	}
	@Bean
    public TuanStatusMapper TuanStatusMapper() throws Exception {
        return newMapperFactoryBean(TuanStatusMapper.class).getObject();
    }
	
	@Bean
    public TuanOrderMapper TuanOrderMapper() throws Exception {
        return newMapperFactoryBean(TuanOrderMapper.class).getObject();
    }
	
}
