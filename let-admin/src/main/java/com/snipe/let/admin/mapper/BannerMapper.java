package com.snipe.let.admin.mapper;
import org.springframework.stereotype.Component;
import com.snipe.let.admin.domain.BannerDomain;
import com.snipe.let.admin.model.BannerModel;

@Component
public class BannerMapper extends AbstractModelMapper<BannerModel, BannerDomain> {

	@Override
	public Class<BannerModel> entityType() {
		// TODO Auto-generated method stub
		return BannerModel.class;
	}

	@Override
	public Class<BannerDomain> modelType() {
		// TODO Auto-generated method stub
		return BannerDomain.class;
	}

}
