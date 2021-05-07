package com.bob.bobapp.api.response_object;

import com.bob.bobapp.api.bean.SectorAllocationObject;
import com.bob.bobapp.api.bean.StockAllocationObject;

import java.util.ArrayList;

public class FundDetailResponse {
        private String Name;
        private String AMCName;
        private String FundManagerDetails;
        private String FundObjectives;
        private String Asset;
        private String Category;
        private String SchemePlan;
        private String SchemeType;
        private String LaunchDate;
        private String FundManager;
        private String RiskReturnMatrix = null;
        private float Benchmark1Month;
        private float Benchmark3Month;
        private float Benchmark6Month;
        private float Benchmark5Year;
        private float Benchmark1Year;
        private float Benchmark3Year;
        private float CategoryAvg1Month;
        private float CategoryAvg3Month;
        private float CategoryAvg6Month;
        private float CategoryAvg1Year;
        private float CategoryAvg3Year;
        private float CategoryAvg5Year;
        private float Returns1Month;
        private float Returns3Month;
        private float Returns6Month;
        private float Returns1Year;
        private float Returns3Year;
        private float Returns5Year;
        private float SchemeCode;
        private String SchemeName;
        private String ProductType;
        private String RecommendationStatus = null;
        private float NAV;
        private String NAVDate;
        private String Industry = null;
        private float IndPercAllocation;
        private String Company = null;
        private float CompPercAllocation;
        private ArrayList<SectorAllocationObject> SectorAllocationResponseCollection;
        private ArrayList<StockAllocationObject> StockAllocationResponseCollection;

        public ArrayList<SectorAllocationObject> getSectorAllocationResponseCollection() {
            return SectorAllocationResponseCollection;
        }

        public void setSectorAllocationResponseCollection(ArrayList<SectorAllocationObject> sectorAllocationResponseCollection) {
            SectorAllocationResponseCollection = sectorAllocationResponseCollection;
        }

        public ArrayList<StockAllocationObject> getStockAllocationResponseCollection() {
            return StockAllocationResponseCollection;
        }

        public void setStockAllocationResponseCollection(ArrayList<StockAllocationObject> stockAllocationResponseCollection) {
            StockAllocationResponseCollection = stockAllocationResponseCollection;
        }

    // Getter Methods

        public String getName() {
            return Name;
        }

        public String getAMCName() {
            return AMCName;
        }

        public String getFundManagerDetails() {
            return FundManagerDetails;
        }

        public String getFundObjectives() {
            return FundObjectives;
        }

        public String getAsset() {
            return Asset;
        }

        public String getCategory() {
            return Category;
        }

        public String getSchemePlan() {
            return SchemePlan;
        }

        public String getSchemeType() {
            return SchemeType;
        }

        public String getLaunchDate() {
            return LaunchDate;
        }

        public String getFundManager() {
            return FundManager;
        }

        public String getRiskReturnMatrix() {
            return RiskReturnMatrix;
        }

        public float getBenchmark1Month() {
            return Benchmark1Month;
        }

        public float getBenchmark3Month() {
            return Benchmark3Month;
        }

        public float getBenchmark6Month() {
            return Benchmark6Month;
        }

        public float getBenchmark5Year() {
            return Benchmark5Year;
        }

        public float getBenchmark1Year() {
            return Benchmark1Year;
        }

        public float getBenchmark3Year() {
            return Benchmark3Year;
        }

        public float getCategoryAvg1Month() {
            return CategoryAvg1Month;
        }

        public float getCategoryAvg3Month() {
            return CategoryAvg3Month;
        }

        public float getCategoryAvg6Month() {
            return CategoryAvg6Month;
        }

        public float getCategoryAvg1Year() {
            return CategoryAvg1Year;
        }

        public float getCategoryAvg3Year() {
            return CategoryAvg3Year;
        }

        public float getCategoryAvg5Year() {
            return CategoryAvg5Year;
        }

        public float getReturns1Month() {
            return Returns1Month;
        }

        public float getReturns3Month() {
            return Returns3Month;
        }

        public float getReturns6Month() {
            return Returns6Month;
        }

        public float getReturns1Year() {
            return Returns1Year;
        }

        public float getReturns3Year() {
            return Returns3Year;
        }

        public float getReturns5Year() {
            return Returns5Year;
        }

        public float getSchemeCode() {
            return SchemeCode;
        }

        public String getSchemeName() {
            return SchemeName;
        }

        public String getProductType() {
            return ProductType;
        }

        public String getRecommendationStatus() {
            return RecommendationStatus;
        }

        public float getNAV() {
            return NAV;
        }

        public String getNAVDate() {
            return NAVDate;
        }

        public String getIndustry() {
            return Industry;
        }

        public float getIndPercAllocation() {
            return IndPercAllocation;
        }

        public String getCompany() {
            return Company;
        }

        public float getCompPercAllocation() {
            return CompPercAllocation;
        }

        // Setter Methods

        public void setName( String Name ) {
            this.Name = Name;
        }

        public void setAMCName( String AMCName ) {
            this.AMCName = AMCName;
        }

        public void setFundManagerDetails( String FundManagerDetails ) {
            this.FundManagerDetails = FundManagerDetails;
        }

        public void setFundObjectives( String FundObjectives ) {
            this.FundObjectives = FundObjectives;
        }

        public void setAsset( String Asset ) {
            this.Asset = Asset;
        }

        public void setCategory( String Category ) {
            this.Category = Category;
        }

        public void setSchemePlan( String SchemePlan ) {
            this.SchemePlan = SchemePlan;
        }

        public void setSchemeType( String SchemeType ) {
            this.SchemeType = SchemeType;
        }

        public void setLaunchDate( String LaunchDate ) {
            this.LaunchDate = LaunchDate;
        }

        public void setFundManager( String FundManager ) {
            this.FundManager = FundManager;
        }

        public void setRiskReturnMatrix( String RiskReturnMatrix ) {
            this.RiskReturnMatrix = RiskReturnMatrix;
        }

        public void setBenchmark1Month( float Benchmark1Month ) {
            this.Benchmark1Month = Benchmark1Month;
        }

        public void setBenchmark3Month( float Benchmark3Month ) {
            this.Benchmark3Month = Benchmark3Month;
        }

        public void setBenchmark6Month( float Benchmark6Month ) {
            this.Benchmark6Month = Benchmark6Month;
        }

        public void setBenchmark5Year( float Benchmark5Year ) {
            this.Benchmark5Year = Benchmark5Year;
        }

        public void setBenchmark1Year( float Benchmark1Year ) {
            this.Benchmark1Year = Benchmark1Year;
        }

        public void setBenchmark3Year( float Benchmark3Year ) {
            this.Benchmark3Year = Benchmark3Year;
        }

        public void setCategoryAvg1Month( float CategoryAvg1Month ) {
            this.CategoryAvg1Month = CategoryAvg1Month;
        }

        public void setCategoryAvg3Month( float CategoryAvg3Month ) {
            this.CategoryAvg3Month = CategoryAvg3Month;
        }

        public void setCategoryAvg6Month( float CategoryAvg6Month ) {
            this.CategoryAvg6Month = CategoryAvg6Month;
        }

        public void setCategoryAvg1Year( float CategoryAvg1Year ) {
            this.CategoryAvg1Year = CategoryAvg1Year;
        }

        public void setCategoryAvg3Year( float CategoryAvg3Year ) {
            this.CategoryAvg3Year = CategoryAvg3Year;
        }

        public void setCategoryAvg5Year( float CategoryAvg5Year ) {
            this.CategoryAvg5Year = CategoryAvg5Year;
        }

        public void setReturns1Month( float Returns1Month ) {
            this.Returns1Month = Returns1Month;
        }

        public void setReturns3Month( float Returns3Month ) {
            this.Returns3Month = Returns3Month;
        }

        public void setReturns6Month( float Returns6Month ) {
            this.Returns6Month = Returns6Month;
        }

        public void setReturns1Year( float Returns1Year ) {
            this.Returns1Year = Returns1Year;
        }

        public void setReturns3Year( float Returns3Year ) {
            this.Returns3Year = Returns3Year;
        }

        public void setReturns5Year( float Returns5Year ) {
            this.Returns5Year = Returns5Year;
        }

        public void setSchemeCode( float SchemeCode ) {
            this.SchemeCode = SchemeCode;
        }

        public void setSchemeName( String SchemeName ) {
            this.SchemeName = SchemeName;
        }

        public void setProductType( String ProductType ) {
            this.ProductType = ProductType;
        }

        public void setRecommendationStatus( String RecommendationStatus ) {
            this.RecommendationStatus = RecommendationStatus;
        }

        public void setNAV( float NAV ) {
            this.NAV = NAV;
        }

        public void setNAVDate( String NAVDate ) {
            this.NAVDate = NAVDate;
        }

        public void setIndustry( String Industry ) {
            this.Industry = Industry;
        }

        public void setIndPercAllocation( float IndPercAllocation ) {
            this.IndPercAllocation = IndPercAllocation;
        }

        public void setCompany( String Company ) {
            this.Company = Company;
        }

        public void setCompPercAllocation( float CompPercAllocation ) {
            this.CompPercAllocation = CompPercAllocation;
        }
}