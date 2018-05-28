/**
 * 
 */
package com.sy.genericmapper;

import org.mapstruct.Mapper;

/**
 * 
 * @author sinan.yumak
 *
 */
@Mapper( componentModel="spring" )
public interface FruitMapper extends GenericMapper<Fruit, FruitDto> {
	
}
