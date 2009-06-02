package VASSAL.configure;

import VASSAL.build.module.properties.PropertySource;
import VASSAL.counters.GamePiece;
import VASSAL.counters.PieceFilter;
import VASSAL.script.expression.Expression;
import VASSAL.script.expression.NullExpression;

/*
 * Class encapsulating a Property Match Expression
 * A PropertyExpression is it's own PieceFilter.
 */
public class PropertyExpression implements PieceFilter {
  
  protected Expression expression = new NullExpression();
  
  public PropertyExpression() {

  }
  
  public PropertyExpression(String s) {
    setExpression(s);
  }

  public void setExpression(String s) {
    expression = Expression.createPropertyExpression(s);
  }

  public String getExpression() {
    return expression.getExpression();
  }

  public boolean isNull() {
    return expression == null || expression instanceof NullExpression;
  }
  
  public PieceFilter getFilter(PropertySource source) {
    return expression.getFilter(source);
  }
  
  public PieceFilter getFilter() {
    return expression.getFilter();
  }

  public boolean accept(GamePiece piece) {
    return getFilter(piece).accept(piece);
  }
  
}

