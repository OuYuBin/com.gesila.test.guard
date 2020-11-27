/**
 */
package com.gesila.test.guard.model.testGuard.impl;

import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.Params;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getParams <em>Params</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getRequestBody <em>Request Body</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getDesc <em>Desc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestGuardImpl extends MinimalEObjectImpl.Container implements TestGuard {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;
	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected String method = METHOD_EDEFAULT;
	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected Headers headers;
	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected Params params;
	/**
	 * The cached value of the '{@link #getRequestBody() <em>Request Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestBody()
	 * @generated
	 * @ordered
	 */
	protected RequestBody requestBody;
	/**
	 * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String DESC_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected String desc = DESC_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestGuardPackage.Literals.TEST_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMethod() {
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMethod(String newMethod) {
		String oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__METHOD, oldMethod, method));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequestBody getRequestBody() {
		return requestBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequestBody(RequestBody newRequestBody, NotificationChain msgs) {
		RequestBody oldRequestBody = requestBody;
		requestBody = newRequestBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__REQUEST_BODY, oldRequestBody, newRequestBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestBody(RequestBody newRequestBody) {
		if (newRequestBody != requestBody) {
			NotificationChain msgs = null;
			if (requestBody != null)
				msgs = ((InternalEObject)requestBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__REQUEST_BODY, null, msgs);
			if (newRequestBody != null)
				msgs = ((InternalEObject)newRequestBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__REQUEST_BODY, null, msgs);
			msgs = basicSetRequestBody(newRequestBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__REQUEST_BODY, newRequestBody, newRequestBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDesc() {
		return desc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDesc(String newDesc) {
		String oldDesc = desc;
		desc = newDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__DESC, oldDesc, desc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Headers getHeaders() {
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaders(Headers newHeaders, NotificationChain msgs) {
		Headers oldHeaders = headers;
		headers = newHeaders;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__HEADERS, oldHeaders, newHeaders);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeaders(Headers newHeaders) {
		if (newHeaders != headers) {
			NotificationChain msgs = null;
			if (headers != null)
				msgs = ((InternalEObject)headers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__HEADERS, null, msgs);
			if (newHeaders != null)
				msgs = ((InternalEObject)newHeaders).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__HEADERS, null, msgs);
			msgs = basicSetHeaders(newHeaders, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__HEADERS, newHeaders, newHeaders));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Params getParams() {
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParams(Params newParams, NotificationChain msgs) {
		Params oldParams = params;
		params = newParams;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__PARAMS, oldParams, newParams);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParams(Params newParams) {
		if (newParams != params) {
			NotificationChain msgs = null;
			if (params != null)
				msgs = ((InternalEObject)params).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__PARAMS, null, msgs);
			if (newParams != null)
				msgs = ((InternalEObject)newParams).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TestGuardPackage.TEST_GUARD__PARAMS, null, msgs);
			msgs = basicSetParams(newParams, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__PARAMS, newParams, newParams));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return basicSetHeaders(null, msgs);
			case TestGuardPackage.TEST_GUARD__PARAMS:
				return basicSetParams(null, msgs);
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				return basicSetRequestBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__NAME:
				return getName();
			case TestGuardPackage.TEST_GUARD__URL:
				return getUrl();
			case TestGuardPackage.TEST_GUARD__METHOD:
				return getMethod();
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return getHeaders();
			case TestGuardPackage.TEST_GUARD__PARAMS:
				return getParams();
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				return getRequestBody();
			case TestGuardPackage.TEST_GUARD__DESC:
				return getDesc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__NAME:
				setName((String)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__URL:
				setUrl((String)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__METHOD:
				setMethod((String)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__HEADERS:
				setHeaders((Headers)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__PARAMS:
				setParams((Params)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				setRequestBody((RequestBody)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__DESC:
				setDesc((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TestGuardPackage.TEST_GUARD__URL:
				setUrl(URL_EDEFAULT);
				return;
			case TestGuardPackage.TEST_GUARD__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
			case TestGuardPackage.TEST_GUARD__HEADERS:
				setHeaders((Headers)null);
				return;
			case TestGuardPackage.TEST_GUARD__PARAMS:
				setParams((Params)null);
				return;
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				setRequestBody((RequestBody)null);
				return;
			case TestGuardPackage.TEST_GUARD__DESC:
				setDesc(DESC_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TestGuardPackage.TEST_GUARD__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case TestGuardPackage.TEST_GUARD__METHOD:
				return METHOD_EDEFAULT == null ? method != null : !METHOD_EDEFAULT.equals(method);
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return headers != null;
			case TestGuardPackage.TEST_GUARD__PARAMS:
				return params != null;
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				return requestBody != null;
			case TestGuardPackage.TEST_GUARD__DESC:
				return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals(desc);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", url: ");
		result.append(url);
		result.append(", method: ");
		result.append(method);
		result.append(", desc: ");
		result.append(desc);
		result.append(')');
		return result.toString();
	}

} //TestGuardImpl
