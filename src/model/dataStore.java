package model;

import java.util.ArrayList;

import src.characterNKS.characterNKS;
import src.dynasty.dynasty;
import src.eventnks.eventnks;
import src.festival.festival;
import src.vietnam.diTichTrenVietnam;

public class dataStore {
   protected ArrayList<characterNKS> character = new ArrayList<characterNKS>();
   protected ArrayList<diTichTrenVietnam> ditichVN = new ArrayList<diTichTrenVietnam>();
   protected ArrayList<festival> festivalsArr = new ArrayList<festival>();
   protected ArrayList<eventnks> eventArr = new ArrayList<eventnks>();
   protected ArrayList<dynasty> dynastiesArr = new ArrayList<dynasty>();
}
