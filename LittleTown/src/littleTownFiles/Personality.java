package littleTownFiles;

 class Personality {
  private int iORe, sORn, fORt, jORp;
  
  public Personality(){
   
  
  }
  
  public void setRandPersonality() {
	  
	 iORe= (int) Math.random()*(10-(-11)+1) - 11;
	 sORn= (int) Math.random()*(10-(-11)+1) - 11;
	 jORp= (int) Math.random()*(10-(-11)+1) - 11;
	 fORt= (int) Math.random()*(10-(-11)+1) - 11;
  }
  public int decrJorP () {
	  if( jORp >=-11)
			 jORp--;
		 
	 return this.jORp;
  }
  public int incrForT () {
	  if( fORt <11)
			 fORt++;
		 
	 return this.fORt;
  }
  
  public int decrForT () {
	  if( fORt >=-11)
			fORt--;
		 
	 return this.fORt;
  }
  
  public int incrIorE () {
	  if( iORe <11)
			 iORe++;
		 
	 return this.iORe;
  }
  public int decrIorE () {
	  if( iORe >=-11)
			 iORe--;
		 
	 return this.iORe;
  }
  public int incrSorN () {
	  if( sORn <11)
			 sORn++;
		 
	 return this.sORn;
  }
  
  public int decrSorN () {
	  if( sORn >=-11)
			 sORn--;
		 
	 return this.sORn;
  }
  public int setIorE(int iORe) {
	 if(iORe >=-11 || iORe <11)
		 this.iORe= iORe;
	 
	 return this.iORe;
  }
  
  public int setSorN (int sORn) {
	  if(sORn >=-11 || sORn <11)
			 this.sORn= sORn;
		 
		 return this.sORn;
  }
  
  public int setForT (int fORt) {
	  if(fORt >=-11 || fORt <11) 
	  this.fORt= fORt;
		 
		 return this.fORt;
  }
  
  public int setJorP(int jORp) {
	  if(jORp >=-11 || jORp <11)
	  this.jORp= jORp;
		 
		 return this.jORp;
  }
  
  public int getIorE() {
	  return iORe;
  }
  
  public int getSorN() {
	  return sORn;
  }
  
  public int getForT() {
	  return fORt;
  }
  
  public int getJorP() {
	  return jORp;
  }
  
  public String pType() {
	  String pType="";
	  if(iORe<0) {
		  pType+="I";
	  }else {
		  pType+="E";
	  }
	  
	  if(sORn<0) {
		  pType+="S";
	  }else {
		  pType+="N";
	  }
	  
	  if(fORt<0) {
		  pType+="F";
	  }else {
		  pType+="T";
	  }
	  
	  if(jORp<0) {
		  pType+="J";
	  }else {
		  pType+="P";
	  }
	  
	 
	  return pType;
  }
}
