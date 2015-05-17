"Include a README.md file in each repository stating what is contained there.
Answering each of the eight points:
1) 
@Override public boolean hasError() { if (errorFlag) return(true); else return(false); }
See general comments. return errorFlag
Also, consider using the inline if ""?:""
@Override public Object getReturnValue() { if(hasError()) return(null); else return(item); }}
2) 
public boolean isEmpty(){ if (this.listItems == null) { return true; } else{ return false; } }
As above.
** * Method that returns the number of items currently in the list. *  * @return the number of items currently in the list */ public int size(){ if (this.isEmpty()) { return 0; } else{ return this.listItems.length; } }
What is the length of an empty list? Could you just return the length?
Try and avoid multiple return points
public ReturnObject get(int index){ if (this.isEmpty()) { return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE); } else{ if( index &lt; this.listItems.length &amp;&amp; index &gt;= 0){ return new ReturnObjectImpl( this.listItems[index]); }else{ return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS); } } }
assign to a temporary variable and return that instead.
See general comments about returning references to internal data structures.
3) See comments above re:
@Override public boolean isEmpty() { if (currentIndex == 0) return(true); else return(false); }
otherwise, good.
4) Good.
5) Good.
6) Good.
7) See above comments…
@Override public boolean isEmpty() { if(internalList.isEmpty()) return(true); else return(false); }
8) Good."
