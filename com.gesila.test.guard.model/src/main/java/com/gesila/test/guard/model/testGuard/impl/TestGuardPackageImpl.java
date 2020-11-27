/**
 */
package com.gesila.test.guard.model.testGuard.impl;

import com.gesila.test.guard.model.testGuard.EntityHeaderFields;
import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.Method;
import com.gesila.test.guard.model.testGuard.Param;
import com.gesila.test.guard.model.testGuard.Params;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardModule;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestGuardPackageImpl extends EPackageImpl implements TestGuardPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGuardModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGuardUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum entityHeaderFieldsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum methodEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestGuardPackageImpl() {
		super(eNS_URI, TestGuardFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TestGuardPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestGuardPackage init() {
		if (isInited) return (TestGuardPackage)EPackage.Registry.INSTANCE.getEPackage(TestGuardPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTestGuardPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TestGuardPackageImpl theTestGuardPackage = registeredTestGuardPackage instanceof TestGuardPackageImpl ? (TestGuardPackageImpl)registeredTestGuardPackage : new TestGuardPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTestGuardPackage.createPackageContents();

		// Initialize created meta-data
		theTestGuardPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestGuardPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestGuardPackage.eNS_URI, theTestGuardPackage);
		return theTestGuardPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestGuard() {
		return testGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuard_Name() {
		return (EAttribute)testGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuard_Url() {
		return (EAttribute)testGuardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuard_Method() {
		return (EAttribute)testGuardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGuard_RequestBody() {
		return (EReference)testGuardEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuard_Desc() {
		return (EAttribute)testGuardEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGuard_Headers() {
		return (EReference)testGuardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGuard_Params() {
		return (EReference)testGuardEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestGuardModule() {
		return testGuardModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGuardModule_Unit() {
		return (EReference)testGuardModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuardModule_Name() {
		return (EAttribute)testGuardModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestGuardUnit() {
		return testGuardUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuardUnit_Name() {
		return (EAttribute)testGuardUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuardUnit_Url() {
		return (EAttribute)testGuardUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuardUnit_RequestBody() {
		return (EAttribute)testGuardUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHeaders() {
		return headersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHeaders_Header() {
		return (EReference)headersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHeader() {
		return headerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHeader_Name() {
		return (EAttribute)headerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHeader_Value() {
		return (EAttribute)headerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequestBody() {
		return requestBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequestBody_Value() {
		return (EAttribute)requestBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParams() {
		return paramsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParams_Param() {
		return (EReference)paramsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParam() {
		return paramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParam_Name() {
		return (EAttribute)paramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParam_Value() {
		return (EAttribute)paramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEntityHeaderFields() {
		return entityHeaderFieldsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMethod() {
		return methodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGuardFactory getTestGuardFactory() {
		return (TestGuardFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testGuardEClass = createEClass(TEST_GUARD);
		createEAttribute(testGuardEClass, TEST_GUARD__NAME);
		createEAttribute(testGuardEClass, TEST_GUARD__URL);
		createEAttribute(testGuardEClass, TEST_GUARD__METHOD);
		createEReference(testGuardEClass, TEST_GUARD__HEADERS);
		createEReference(testGuardEClass, TEST_GUARD__PARAMS);
		createEReference(testGuardEClass, TEST_GUARD__REQUEST_BODY);
		createEAttribute(testGuardEClass, TEST_GUARD__DESC);

		testGuardModuleEClass = createEClass(TEST_GUARD_MODULE);
		createEReference(testGuardModuleEClass, TEST_GUARD_MODULE__UNIT);
		createEAttribute(testGuardModuleEClass, TEST_GUARD_MODULE__NAME);

		testGuardUnitEClass = createEClass(TEST_GUARD_UNIT);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__NAME);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__URL);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__REQUEST_BODY);

		headersEClass = createEClass(HEADERS);
		createEReference(headersEClass, HEADERS__HEADER);

		headerEClass = createEClass(HEADER);
		createEAttribute(headerEClass, HEADER__NAME);
		createEAttribute(headerEClass, HEADER__VALUE);

		requestBodyEClass = createEClass(REQUEST_BODY);
		createEAttribute(requestBodyEClass, REQUEST_BODY__VALUE);

		paramsEClass = createEClass(PARAMS);
		createEReference(paramsEClass, PARAMS__PARAM);

		paramEClass = createEClass(PARAM);
		createEAttribute(paramEClass, PARAM__NAME);
		createEAttribute(paramEClass, PARAM__VALUE);

		// Create enums
		entityHeaderFieldsEEnum = createEEnum(ENTITY_HEADER_FIELDS);
		methodEEnum = createEEnum(METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(testGuardEClass, TestGuard.class, "TestGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestGuard_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuard_Url(), ecorePackage.getEString(), "url", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuard_Method(), ecorePackage.getEString(), "method", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGuard_Headers(), this.getHeaders(), null, "Headers", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGuard_Params(), this.getParams(), null, "Params", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGuard_RequestBody(), this.getRequestBody(), null, "requestBody", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuard_Desc(), ecorePackage.getEString(), "desc", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGuardModuleEClass, TestGuardModule.class, "TestGuardModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestGuardModule_Unit(), this.getTestGuardUnit(), null, "Unit", null, 0, -1, TestGuardModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGuardModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGuardUnitEClass, TestGuardUnit.class, "TestGuardUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestGuardUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardUnit_Url(), ecorePackage.getEString(), "url", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardUnit_RequestBody(), ecorePackage.getEString(), "requestBody", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headersEClass, Headers.class, "Headers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHeaders_Header(), this.getHeader(), null, "Header", null, 0, -1, Headers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headerEClass, Header.class, "Header", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeader_Name(), ecorePackage.getEString(), "name", null, 0, 1, Header.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeader_Value(), ecorePackage.getEString(), "value", null, 0, 1, Header.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestBodyEClass, RequestBody.class, "RequestBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestBody_Value(), ecorePackage.getEString(), "value", null, 0, 1, RequestBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramsEClass, Params.class, "Params", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParams_Param(), this.getParam(), null, "Param", null, 0, -1, Params.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParam_Value(), ecorePackage.getEString(), "value", null, 0, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(entityHeaderFieldsEEnum, EntityHeaderFields.class, "EntityHeaderFields");
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.ALLOW);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_ENCODING);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_LANGUAGE);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_LENGTH);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_LOCATION);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_MD5);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_RANGE);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.CONTENT_TYPE);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.EXPIRES);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.LAST_MODIFIED);
		addEEnumLiteral(entityHeaderFieldsEEnum, EntityHeaderFields.ACCEPT);

		initEEnum(methodEEnum, Method.class, "Method");
		addEEnumLiteral(methodEEnum, Method.GET);
		addEEnumLiteral(methodEEnum, Method.POST);
		addEEnumLiteral(methodEEnum, Method.UPDATE);
		addEEnumLiteral(methodEEnum, Method.PUT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "ExtendedMetaData";
		addAnnotation
		  (entityHeaderFieldsEEnum.getELiterals().get(7),
		   source,
		   new String[] {
			   "desc", "\u5b9e\u4f53\u4e3b\u4f53\u5185\u5bf9\u8c61\u7684\u5a92\u4f53\u7c7b\u578b",
			   "content", "application/json|application/xml|application/x-www-form-urlencoded"
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EString/%http:%2F%2F%2Forg%2Feclipse%2Femf%2Fecore%2Futil%2FExtendedMetaData%")
		   });
		addAnnotation
		  (entityHeaderFieldsEEnum.getELiterals().get(10),
		   source,
		   new String[] {
			   "desc", "\u6307\u5b9a\u5ba2\u6237\u7aef\u80fd\u591f\u63a5\u6536\u7684\u5185\u5bb9\u7c7b\u578b",
			   "content", "application/json|text/plain"
		   },
		   new URI[] {
			 URI.createURI(EcorePackage.eNS_URI).appendFragment("//EString/%http:%2F%2F%2Forg%2Feclipse%2Femf%2Fecore%2Futil%2FExtendedMetaData%")
		   });
	}

} //TestGuardPackageImpl
