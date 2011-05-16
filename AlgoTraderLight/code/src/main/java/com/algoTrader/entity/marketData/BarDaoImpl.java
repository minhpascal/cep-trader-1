// Generated by: hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.algoTrader.entity.marketData;

import org.hibernate.Hibernate;

import com.algoTrader.entity.Security;
import com.algoTrader.vo.BarVO;
import com.algoTrader.vo.RawTickVO;

/**
 * @see Bar
 */
public class BarDaoImpl extends BarDaoBase {

    public void toBarVO(Bar bar,  BarVO barVO) {

        super.toBarVO(bar, barVO);
        
        completeBarVO(bar, barVO);
    }


    public BarVO toBarVO(final Bar bar) {
    	
		BarVO rawBarVO = super.toBarVO(bar);

		completeBarVO(bar, rawBarVO);

		return rawBarVO;    	
    }


	private void completeBarVO(Bar bar, BarVO barVO) {

		barVO.setIsin(bar.getSecurity().getIsin());
	}

	/**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Bar loadBarFromBarVO(BarVO barVO)
    {
        // TODO implement loadBarFromBarVO
        throw new UnsupportedOperationException("com.algoTrader.entity.marketData.loadBarFromBarVO(BarVO) not yet implemented.");

        /* A typical implementation looks like this:
        Bar bar = this.load(barVO.getId());
        if (bar == null)
        {
            bar = Bar.Factory.newInstance();
        }
        return bar;
        */
    }


    /**
     * 
     */
    public Bar barVOToEntity(BarVO barVO) {

    	Bar bar = new BarImpl();
		super.barVOToEntity(barVO, bar, true);
	
		Security security = getSecurityDao().findByIsinFetched(barVO.getIsin());
	
		// initialize the proxys
		Hibernate.initialize(security.getUnderlaying());
		Hibernate.initialize(security.getSecurityFamily());
	
		bar.setSecurity(security);
	
		return bar;
    }


    /**
     * 
     */
    public void barVOToEntity(
        BarVO source,
        Bar target,
        boolean copyIfNull)
    {
        // TODO verify behavior of barVOToEntity
        super.barVOToEntity(source, target, copyIfNull);
    }

}