package modelo;
// Generated 26-09-2018 15:18:05 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * ComunaId generated by hbm2java
 */
public class ComunaId  implements java.io.Serializable {


     private BigDecimal idComuna;
     private BigDecimal regionIdRegion;

    public ComunaId() {
    }

    public ComunaId(BigDecimal idComuna, BigDecimal regionIdRegion) {
       this.idComuna = idComuna;
       this.regionIdRegion = regionIdRegion;
    }
   
    public BigDecimal getIdComuna() {
        return this.idComuna;
    }
    
    public void setIdComuna(BigDecimal idComuna) {
        this.idComuna = idComuna;
    }
    public BigDecimal getRegionIdRegion() {
        return this.regionIdRegion;
    }
    
    public void setRegionIdRegion(BigDecimal regionIdRegion) {
        this.regionIdRegion = regionIdRegion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ComunaId) ) return false;
		 ComunaId castOther = ( ComunaId ) other; 
         
		 return ( (this.getIdComuna()==castOther.getIdComuna()) || ( this.getIdComuna()!=null && castOther.getIdComuna()!=null && this.getIdComuna().equals(castOther.getIdComuna()) ) )
 && ( (this.getRegionIdRegion()==castOther.getRegionIdRegion()) || ( this.getRegionIdRegion()!=null && castOther.getRegionIdRegion()!=null && this.getRegionIdRegion().equals(castOther.getRegionIdRegion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdComuna() == null ? 0 : this.getIdComuna().hashCode() );
         result = 37 * result + ( getRegionIdRegion() == null ? 0 : this.getRegionIdRegion().hashCode() );
         return result;
   }   


}


