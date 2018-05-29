/**
 * 
 */
package com.sy.genericmapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author sinan.yumak
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = {GenericMapperConfig.class} )
public class GenericMapperTest {

	@Autowired
	private GenericMapperService mapperService;
	

	@Test
	public void givenValidSourceAndTargetType_whenMapperRequested_ThenAMapperShouldBeFound() {
		
		// given 
		Class<Fruit> sourceClass = Fruit.class;
		Class<FruitDto> targetClass = FruitDto.class;
		
		// when 
		GenericMapper mapper =  mapperService.getMapper( sourceClass, targetClass );

		// then 
		Assert.assertNotNull( mapper );
		Assert.assertTrue( mapper instanceof FruitMapper );
	}
	
	
	@Test
	public void givenAModelObject_whenModelConvertedToDto_ThenAValidDtoShouldBeCreated() {
		
		// given 
		Fruit banana = new Fruit();
		banana.setName( "Banana" );
		banana.setColor( "Yellow" );
		
		// when 
		GenericMapper<Fruit, FruitDto> mapper =  mapperService.getMapper( Fruit.class, FruitDto.class );
		FruitDto result = mapper.toDto( banana );
		
		// then 
		Assert.assertEquals( banana.getName(), result.getName() );
		Assert.assertEquals( banana.getColor(), result.getColor() );
	}
	
}
