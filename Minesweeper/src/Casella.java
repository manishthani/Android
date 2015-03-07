import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="Casella")
@IdClass(value=CasellaPK.class)
public class Casella implements Serializable{
	
	@Id
	private Integer idPartida;
	
	@Id
	private Integer numeroFila;
	
	@Id
	private Integer numeroColumna;
	
	private Integer numero;
	
	private Boolean estaDescoberta;
	
	private Boolean estaMarcada;
	
	private Boolean teMina;
	
	
	public Casella(){}
	
	public Casella(Integer idPartida, Integer numeroFila, Integer numeroColumna, Boolean estaDescoberta, Boolean estaMarcada, Boolean teMina){
		this.idPartida = idPartida;
		this.numeroFila = numeroFila;
		this.numeroColumna = numeroColumna;
		this.estaDescoberta = estaDescoberta;
		this.estaMarcada = estaMarcada;
		this.teMina = teMina;
		numero = 0;
	}
	
	public Integer getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public Integer getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(Integer numeroFila) {
		this.numeroFila = numeroFila;
	}
	public Integer getNumeroColumna() {
		return numeroColumna;
	}
	public void setNumeroColumna(Integer numeroColumna) {
		this.numeroColumna = numeroColumna;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Boolean getEstaDescoberta() {
		return estaDescoberta;
	}
	public void setEstaDescoberta(Boolean estaDescoberta) {
		this.estaDescoberta = estaDescoberta;
	}
	public Boolean getEstaMarcada() {
		return estaMarcada;
	}
	public void setEstaMarcada(Boolean estaMarcada) {
		this.estaMarcada = estaMarcada;
	}
	public Boolean getTeMina() {
		return teMina;
	}
	public void setTeMina(Boolean teMina) {
		this.teMina = teMina;
	}
	

}


class CasellaPK implements Serializable{
        
        
        
        private Integer idPartida;
        
        private Integer numeroFila;
        
        private Integer numeroColumna;

        
        public CasellaPK() {
        }
        

        public Integer getPartida() {
			return idPartida;
		}


		public void setPartida(Integer partida) {
			this.idPartida = idPartida;
		}

		public Integer getNumeroFila() {
                return numeroFila;
        }

        public void setNumeroFila(Integer numeroFila) {
                this.numeroFila = numeroFila;
        }


        public Integer getNumeroColumna() {
                return numeroColumna;
        }


        public void setNumeroColumna(Integer numeroColumna) {
                this.numeroColumna = numeroColumna;
        }


        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result
                                + ((idPartida == null) ? 0 : idPartida.hashCode());
                result = prime * result
                                + ((numeroColumna == null) ? 0 : numeroColumna.hashCode());
                result = prime * result
                                + ((numeroFila == null) ? 0 : numeroFila.hashCode());
                return result;
        }

        
        //Puede ser que haya que cambiar por CasellaPK

        @Override
        public boolean equals(Object obj) {
                 if (this == obj) return true;
                if ( !(obj instanceof CasellaPK) ) return false;

                final CasellaPK cat = (CasellaPK) obj;

                if ( !cat.getNumeroFila().equals(numeroFila) ) return false;
                if ( !cat.getPartida().equals(idPartida) ) return false;
                if ( !cat.getNumeroColumna().equals(numeroColumna) ) return false;
                return true;
        }
        
        
        


}
