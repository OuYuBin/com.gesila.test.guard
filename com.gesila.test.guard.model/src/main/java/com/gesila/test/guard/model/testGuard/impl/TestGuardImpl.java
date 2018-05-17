/**
 */
package com.gesila.test.guard.model.testGuard.impl;

import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.RequestMethod;
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
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getRequestBody <em>Request Body</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getRequestMethod <em>Request Method</em>}</li>
 *   <li>{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl#getHeaders <em>Headers</em>}</li>
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
	 * The default value of the '{@link #getRequestBody() <em>Request Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestBody()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUEST_BODY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRequestBody() <em>Request Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestBody()
	 * @generated
	 * @ordered
	 */
	protected String requestBody = REQUEST_BODY_EDEFAULT;
	/**
	 * The default value of the '{@link #getRequestMethod() <em>Request Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestMethod()
	 * @generated
	 * @ordered
	 */
	protected static final RequestMethod REQUEST_METHOD_EDEFAULT = RequestMethod.POST;
	/**
	 * The cached value of the '{@link #getRequestMethod() <em>Request Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequestMethod()
	 * @generated
	 * @ordered
	 */
	protected RequestMethod requestMethod = REQUEST_METHOD_EDEFAULT;
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
	public String getRequestBody() {
		return requestBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestBody(String newRequestBody) {
		String oldRequestBody = requestBody;
		requestBody = newRequestBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__REQUEST_BODY, oldRequestBody, requestBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequestMethod getRequestMethod() {
		return requestMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequestMethod(RequestMethod newRequestMethod) {
		RequestMethod oldRequestMethod = requestMethod;
		requestMethod = newRequestMethod == null ? REQUEST_METHOD_EDEFAULT : newRequestMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestGuardPackage.TEST_GUARD__REQUEST_METHOD, oldRequestMethod, requestMethod));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return basicSetHeaders(null, msgs);
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
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				return getRequestBody();
			case TestGuardPackage.TEST_GUARD__REQUEST_METHOD:
				return getRequestMethod();
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return getHeaders();
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
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				setRequestBody((String)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__REQUEST_METHOD:
				setRequestMethod((RequestMethod)newValue);
				return;
			case TestGuardPackage.TEST_GUARD__HEADERS:
				setHeaders((Headers)newValue);
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
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				setRequestBody(REQUEST_BODY_EDEFAULT);
				return;
			case TestGuardPackage.TEST_GUARD__REQUEST_METHOD:
				setRequestMethod(REQUEST_METHOD_EDEFAULT);
				return;
			case TestGuardPackage.TEST_GUARD__HEADERS:
				setHeaders((Headers)null);
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
			case TestGuardPackage.TEST_GUARD__REQUEST_BODY:
				return REQUEST_BODY_EDEFAULT == null ? requestBody != null : !REQUEST_BODY_EDEFAULT.equals(requestBody);
			case TestGuardPackage.TEST_GUARD__REQUEST_METHOD:
				return requestMethod != REQUEST_METHOD_EDEFAULT;
			case TestGuardPackage.TEST_GUARD__HEADERS:
				return headers != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", url: ");
		result.append(url);
		result.append(", requestBody: ");
		result.append(requestBody);
		result.append(", requestMethod: ");
		result.append(requestMethod);
		result.append(')');
		return result.toString();
	}

} //TestGuardImpl
