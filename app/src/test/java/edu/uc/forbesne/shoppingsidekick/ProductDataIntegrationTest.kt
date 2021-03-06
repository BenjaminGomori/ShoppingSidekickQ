package edu.uc.forbesne.shoppingsidekick
// based onp professor's code - https://github.com/discospiff/MyPlantDiaryQ

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import edu.uc.forbesne.shoppingsidekick.dto.Product
import edu.uc.forbesne.shoppingsidekick.service.ProductService
import edu.uc.forbesne.shoppingsidekick.ui.main.MainViewModel
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import java.lang.Thread.sleep

/**
 * Integration test, verifies MainViewModel fetchAllProducts successful
 *
 */
class ProductDataIntegrationTest {

    @get:Rule
    var rule: TestRule =  InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    @Test
    fun confirmChips_outputsChips () {
        var product: Product = Product("100000001", 2.5f,"Item","Best Chips","Snacks",   "chipsImageURL","Chips",1)
        assertEquals("Description: Chips, Price: 2.5, Category: Snacks", product.toString());
    }

    @Test
    fun requestAllProductsFromShopOne_returnsAllProductsFromShopOne() {
        givenAFeedOfProductDataAreAvailable()
        whenRequestAllProductsFromShopOne()
        thenResultIsNotEmpty()
    }

    private fun givenAFeedOfProductDataAreAvailable() {
        mvm = MainViewModel()
    }

    private fun whenRequestAllProductsFromShopOne() {
        mvm.fetchAllProducts()
    }

    private fun thenResultIsNotEmpty() {
        // should makes sure thread is used only after enough time for response to be back
        sleep(4000)
        mvm.products.observeForever {
            assertNotNull(it)
            assertTrue(it.size > 0)
            //does work
            //assertTrue(it.size == 25)
        }
    }
}