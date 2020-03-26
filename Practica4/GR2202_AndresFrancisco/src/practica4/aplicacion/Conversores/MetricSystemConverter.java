/**
 * Este fichero MetricSystemConverter.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 12/4/2017
 */
package practica4.aplicacion.Conversores;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.Excepciones.UnknownUnitException;
import practica4.aplicacion.Magnitudes.IMagnitude;
import practica4.aplicacion.Magnitudes.Magnitude;
import practica4.aplicacion.SistemasMetricos.IMetricSystem;
import practica4.aplicacion.SistemasMetricos.MetricSystem;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;

/**
 * Clase encargada de implementar la generalizacion de todos los conversores de 
 * sistemas metricos distintos 
 * @author Andres y Francsico
 */
public abstract class MetricSystemConverter implements IMetricSystemConverter {
	
	/** Sistema metrico fuente */
	private MetricSystem fuente;
	
	/** Sistema metrico de destino */
	private MetricSystem destino;
	
	/** Coeficiente de conversion entre las bases de ambos sistemas */
	private double conversionBases = 0;

	/**
	 * Constrcutor principal de la clase
	 * @param fuente : sistema fuente
	 * @param destino : sistema de destino
	 * @param conversionBases : coeficiente de conversion
	 */
	public MetricSystemConverter(MetricSystem fuente, MetricSystem destino, double conversionBases) {
		this.fuente = fuente;
		this.destino = destino;
		this.conversionBases = conversionBases;
	}
	
	/**
	 * Constructor vacio de la clase
	 */
	public MetricSystemConverter() {
		
	}
	
	public void setFuente(MetricSystem fuente) {
		this.fuente = fuente;
	}

	public void setDestino(MetricSystem destino) {
		this.destino = destino;
	}

	public void setConversionBases(double conversionBases) {
		this.conversionBases = conversionBases;
	}

	@Override
	/**
	 * Obtiene el sistema fuente del conversor
	 * @return sistema fuente
	 */
	public IMetricSystem sourceSystem() {
		return fuente;
	}

	@Override
	/**
	 * Obtiene el sistema de destino del conversor
	 * @return sistema destino
	 */
	public IMetricSystem targetSystem() {
		return destino;
	}

	@Override
	/**
	 * Se encarga de transformar magnitudes entre distintos sistemas
	 * @param from : magnitud a transformar
	 * @param to : unidad de destino
	 * @return magnitud que resulta de la transformacion
	 * @throws UnknownUnitException
	 * @throws QuantityException
	 */
	public IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException, QuantityException {
		Magnitude aux;
		if (isInSourceSystem((PhysicalUnit)from.getUnidad()) == false || isInTargetSystem((PhysicalUnit)to) == false) {
			throw new UnknownUnitException(from, to);
		}
		aux = Magnitude.getCopy(from);
		
		/* Transformamos la magnitud de partida a su base */
		try {
			aux.transformTo(aux.getUnidad().getMetricSystem().base());
		} catch (QuantityException e) {
			throw e;
		}
		
		/* Transformamos la magnitud de partida normalizada a la base del sistema de destino */
		aux.setValor(aux.getValor() * conversionBases);
		aux.setUnidad((PhysicalUnit)to.getMetricSystem().base());
		
		/* Finalmente transformamos la magnitud a devolver (inicialmente normalizada) en la unidad indicada */
		try {
			aux.transformTo(to);
		} catch (QuantityException e) {
			throw e;
		}
		
		return aux;
	}

	@Override
	/**
	 * Obtiene el conversor inverso al actual
	 * @return conversor inverso
	 */
	public IMetricSystemConverter reverse() {
		MetricSystemConverter aux = new VoidMetricSystemConverter();
		aux.setFuente(destino);
		aux.setDestino(fuente);
		aux.setConversionBases(1 / conversionBases);
		
		return aux;
	}
	
	/**
	 * Comprueba si una deterinada unidad fisica pertenece al sistema fuente de este conversor
	 * @param u : unidad fisica a buscar
	 * @return true si se ha encontrado, false en caso contrario
	 */
	private boolean isInSourceSystem(PhysicalUnit u) {
		return fuente.isInMetricSystem(u);
	}
	
	/**
	 * Comprueba si una deterinada unidad fisica pertenece al sistema de destino de este conversor
	 * @param u : unidad fisica a buscar
	 * @return true si se ha encontrado, false en caso contrario
	 */
	private boolean isInTargetSystem(PhysicalUnit u) {
		return destino.isInMetricSystem(u);
	}

}
