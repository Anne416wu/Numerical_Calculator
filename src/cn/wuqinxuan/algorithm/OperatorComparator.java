package cn.wuqinxuan.algorithm;

/**
 * Created by Wuqinxuan on 2018/11/19.
 */

public class OperatorComparator {

    public static char compareOperator(Unit u1, Unit u2) throws ExpressionIllegalException {

        if (!(u1.isOperator() && u2.isOperator())) {
            throw new ExpressionIllegalException();
        }
        if (u1.isNormalOperator() && u2.isNormalOperator()) {
            if (u1.getType() == Unit.Type.POEWR && u2.getType() == Unit.Type.NEGATIVE) {
                return '<';
            }
            return u1.getPriority() >= u2.getPriority() ? '>' : '<';
        } else if (u2.getType() == Unit.Type.LEFT_BRACKET) {
            return '<';
        } else if (u1.getType() == Unit.Type.LEFT_BRACKET) {
            if (u2.isNormalOperator()) {
                return '<';
            } else if (u2.getType() == Unit.Type.RIGHT_BRACKET) {
                return '=';
            }
        } else if (u1.getType() == Unit.Type.START_STOP_SIGN) {
            if (u2.isNormalOperator()) {
                return '<';
            } else if (u2.getType() == Unit.Type.START_STOP_SIGN) {
                return '=';
            }
        } else if (u1.isNormalOperator()) {
            return '>';
        }
        throw new ExpressionIllegalException();
    }
}
