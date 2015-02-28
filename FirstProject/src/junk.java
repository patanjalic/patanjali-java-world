class junk{
	private String k1;
	private String k2;
	
/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((k1 == null) ? 0 : k1.hashCode());
		result = prime * result + ((k2 == null) ? 0 : k2.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof junk)) {
			return false;
		}
		junk other = (junk) obj;
		if (k1 == null) {
			if (other.k1 != null) {
				return false;
			}
		} else if (!k1.equals(other.k1)) {
			return false;
		}
		if (k2 == null) {
			if (other.k2 != null) {
				return false;
			}
		} else if (!k2.equals(other.k2)) {
			return false;
		}
		return true;
	}

public void abc(){
		
	}
}
class b extends junk{
	public void abc(){
		
	}
	public static void main(String[] args) {
		//b B = (b) new a();
		junk A = new b();
		//b B = new junk();
	}
}
