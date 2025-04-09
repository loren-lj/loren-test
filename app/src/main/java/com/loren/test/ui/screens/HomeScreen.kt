package com.loren.test.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.loren.test.model.Product
import com.loren.test.model.ProductCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val categories = remember { getDummyData() }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("HitPaw") },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Account")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                Text(
                    text = "Featured Products",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            
            categories.forEach { category ->
                item {
                    CategorySection(category)
                }
            }
        }
    }
}

@Composable
fun CategorySection(category: ProductCategory) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = category.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(category.products) { product ->
                ProductCard(product)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .padding(vertical = 8.dp),
        onClick = { /* TODO */ }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                AsyncImage(
                    model = product.imageUrl ?: "https://via.placeholder.com/300",
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                
                if (product.isHot) {
                    Surface(
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.error,
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(
                            "HOT",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = product.platform,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Try It Free")
            }
        }
    }
}

private fun getDummyData(): List<ProductCategory> {
    return listOf(
        ProductCategory(
            "Video AI",
            listOf(
                Product(
                    "HitPaw Univd",
                    "Convert, Edit and Compress Videos on Windows",
                    isHot = true,
                    platform = "Windows"
                ),
                Product(
                    "HitPaw VikPea",
                    "Enhance Videos with AI on Windows",
                    isNew = true,
                    platform = "Windows"
                ),
                Product(
                    "HitPaw Video Object Remover",
                    "Remove Unwanted Object from Videos",
                    platform = "Windows & Mac"
                )
            )
        ),
        ProductCategory(
            "Photo AI",
            listOf(
                Product(
                    "HitPaw FotorPea",
                    "AI Enhance Photos on Windows",
                    isHot = true,
                    platform = "Windows"
                ),
                Product(
                    "HitPaw Photo Object Remover",
                    "Remove Unwanted Objects from Photos",
                    platform = "Windows & Mac"
                ),
                Product(
                    "HitPaw AI Marvels",
                    "AI Enhance and Edit Photos",
                    isNew = true,
                    platform = "iOS & Android"
                )
            )
        ),
        ProductCategory(
            "Audio AI",
            listOf(
                Product(
                    "HitPaw VoicePea",
                    "Change Voice in Real-Time using AI",
                    isHot = true,
                    platform = "Windows & Mac"
                )
            )
        )
    )
} 