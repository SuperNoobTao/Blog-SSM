package cn.edu.zucc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shentao on 2016/7/7.
 */
public abstract class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andUserIdIsNull() {
        addCriterion("USER_ID is null");
        return (Criteria) this;
    }

    public Criteria andUserIdIsNotNull() {
        addCriterion("USER_ID is not null");
        return (Criteria) this;
    }

    public Criteria andUserIdEqualTo(Integer value) {
        addCriterion("USER_ID =", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdNotEqualTo(Integer value) {
        addCriterion("USER_ID <>", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdGreaterThan(Integer value) {
        addCriterion("USER_ID >", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
        addCriterion("USER_ID >=", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdLessThan(Integer value) {
        addCriterion("USER_ID <", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdLessThanOrEqualTo(Integer value) {
        addCriterion("USER_ID <=", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdIn(List<Integer> values) {
        addCriterion("USER_ID in", values, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdNotIn(List<Integer> values) {
        addCriterion("USER_ID not in", values, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdBetween(Integer value1, Integer value2) {
        addCriterion("USER_ID between", value1, value2, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
        addCriterion("USER_ID not between", value1, value2, "userId");
        return (Criteria) this;
    }

    public Criteria andUserNameIsNull() {
        addCriterion("USER_NAME is null");
        return (Criteria) this;
    }

    public Criteria andUserNameIsNotNull() {
        addCriterion("USER_NAME is not null");
        return (Criteria) this;
    }

    public Criteria andUserNameEqualTo(String value) {
        addCriterion("USER_NAME =", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameNotEqualTo(String value) {
        addCriterion("USER_NAME <>", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameGreaterThan(String value) {
        addCriterion("USER_NAME >", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameGreaterThanOrEqualTo(String value) {
        addCriterion("USER_NAME >=", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameLessThan(String value) {
        addCriterion("USER_NAME <", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameLessThanOrEqualTo(String value) {
        addCriterion("USER_NAME <=", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameLike(String value) {
        addCriterion("USER_NAME like", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameNotLike(String value) {
        addCriterion("USER_NAME not like", value, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameIn(List<String> values) {
        addCriterion("USER_NAME in", values, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameNotIn(List<String> values) {
        addCriterion("USER_NAME not in", values, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameBetween(String value1, String value2) {
        addCriterion("USER_NAME between", value1, value2, "userName");
        return (Criteria) this;
    }

    public Criteria andUserNameNotBetween(String value1, String value2) {
        addCriterion("USER_NAME not between", value1, value2, "userName");
        return (Criteria) this;
    }

    public Criteria andUserPasswordIsNull() {
        addCriterion("USER_PASSWORD is null");
        return (Criteria) this;
    }

    public Criteria andUserPasswordIsNotNull() {
        addCriterion("USER_PASSWORD is not null");
        return (Criteria) this;
    }

    public Criteria andUserPasswordEqualTo(String value) {
        addCriterion("USER_PASSWORD =", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordNotEqualTo(String value) {
        addCriterion("USER_PASSWORD <>", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordGreaterThan(String value) {
        addCriterion("USER_PASSWORD >", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
        addCriterion("USER_PASSWORD >=", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordLessThan(String value) {
        addCriterion("USER_PASSWORD <", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordLessThanOrEqualTo(String value) {
        addCriterion("USER_PASSWORD <=", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordLike(String value) {
        addCriterion("USER_PASSWORD like", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordNotLike(String value) {
        addCriterion("USER_PASSWORD not like", value, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordIn(List<String> values) {
        addCriterion("USER_PASSWORD in", values, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordNotIn(List<String> values) {
        addCriterion("USER_PASSWORD not in", values, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordBetween(String value1, String value2) {
        addCriterion("USER_PASSWORD between", value1, value2, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserPasswordNotBetween(String value1, String value2) {
        addCriterion("USER_PASSWORD not between", value1, value2, "userPassword");
        return (Criteria) this;
    }

    public Criteria andUserEmailIsNull() {
        addCriterion("USER_EMAIL is null");
        return (Criteria) this;
    }

    public Criteria andUserEmailIsNotNull() {
        addCriterion("USER_EMAIL is not null");
        return (Criteria) this;
    }

    public Criteria andUserEmailEqualTo(String value) {
        addCriterion("USER_EMAIL =", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailNotEqualTo(String value) {
        addCriterion("USER_EMAIL <>", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailGreaterThan(String value) {
        addCriterion("USER_EMAIL >", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
        addCriterion("USER_EMAIL >=", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailLessThan(String value) {
        addCriterion("USER_EMAIL <", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailLessThanOrEqualTo(String value) {
        addCriterion("USER_EMAIL <=", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailLike(String value) {
        addCriterion("USER_EMAIL like", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailNotLike(String value) {
        addCriterion("USER_EMAIL not like", value, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailIn(List<String> values) {
        addCriterion("USER_EMAIL in", values, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailNotIn(List<String> values) {
        addCriterion("USER_EMAIL not in", values, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailBetween(String value1, String value2) {
        addCriterion("USER_EMAIL between", value1, value2, "userEmail");
        return (Criteria) this;
    }

    public Criteria andUserEmailNotBetween(String value1, String value2) {
        addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
        return (Criteria) this;
    }
}