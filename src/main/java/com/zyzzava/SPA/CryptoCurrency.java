package com.zyzzava.SPA;

public class CryptoCurrency {
    private String rank;
    private String name;
    private String symbol;
    private String price;
    private String marketcap;
    private String vol24H;
    private String totalVol;
    private String chg24H;
    private String chg7D;

    public CryptoCurrency(String rank, String name, String symbol, String price, String marketcap, String vol24H, String totalVol, String chg24H, String chg7D) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.marketcap = marketcap;
        this.vol24H = vol24H;
        this.totalVol = totalVol;
        this.chg24H = chg24H;
        this.chg7D = chg7D;
    }
    // TODO Add getters and setters
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getMarketcap() {
        return marketcap;
    }
    public void setMarketcap(String marketcap) {
        this.marketcap = marketcap;
    }
    public String getVol24H() {
        return vol24H;
    }
    public void setVol24H(String vol24h) {
        vol24H = vol24h;
    }
    public String getTotalVol() {
        return totalVol;
    }
    public void setTotalVol(String totalVol) {
        this.totalVol = totalVol;
    }
    public String getChg24H() {
        return chg24H;
    }
    public void setChg24H(String chg24h) {
        chg24H = chg24h;
    }
    public String getChg7D() {
        return chg7D;
    }
    public void setChg7D(String chg7d) {
        chg7D = chg7d;
    }

    // TODO Add toString method for visual representation
}
