package rental;

public interface VehicleFilter {
	  /** return true if this filter accepts the given vehicle.
      *  v is then said to be selected by this filter.
	   * @param v the vehicle that must be tested by the filter
	   * @return true if and only if the vehicle v is accepted by this filter.
	  */
    public boolean accept(Vehicle v);
}
