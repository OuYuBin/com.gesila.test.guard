/**
 */
package com.gesila.test.guard.model.testGuard.impl;

import com.gesila.test.guard.model.testGuard.Header;
import com.gesila.test.guard.model.testGuard.Headers;
import com.gesila.test.guard.model.testGuard.RequestBody;
import com.gesila.test.guard.model.testGuard.RequestMethod;
import com.gesila.test.guard.model.testGuard.TestGuard;
import com.gesila.test.guard.model.testGuard.TestGuardFactory;
import com.gesila.test.guard.model.testGuard.TestGuardModule;
import com.gesila.test.guard.model.testGuard.TestGuardPackage;
import com.gesila.test.guard.model.testGuard.TestGuardUnit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	private EEnum requestMethodEEnum = null;

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
		TestGuardPackageImpl theTestGuardPackage = (TestGuardPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestGuardPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestGuardPackageImpl());

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
	public EReference getTestGuard_RequestBody() {
		return (EReference)testGuardEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGuard_RequestMethod() {
		return (EAttribute)testGuardEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getTestGuardUnit_RequestMethod() {
		return (EAttribute)testGuardUnitEClass.getEStructuralFeatures().get(3);
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
	public EClass getRequestBody() {
		return requestBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestBody_Value() {
		return (EAttribute)requestBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRequestMethod() {
		return requestMethodEEnum;
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
		createEAttribute(testGuardEClass, TEST_GUARD__REQUEST_METHOD);
		createEReference(testGuardEClass, TEST_GUARD__HEADERS);
		createEReference(testGuardEClass, TEST_GUARD__REQUEST_BODY);

		testGuardModuleEClass = createEClass(TEST_GUARD_MODULE);
		createEReference(testGuardModuleEClass, TEST_GUARD_MODULE__UNIT);
		createEAttribute(testGuardModuleEClass, TEST_GUARD_MODULE__NAME);

		testGuardUnitEClass = createEClass(TEST_GUARD_UNIT);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__NAME);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__URL);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__REQUEST_BODY);
		createEAttribute(testGuardUnitEClass, TEST_GUARD_UNIT__REQUEST_METHOD);

		headersEClass = createEClass(HEADERS);
		createEReference(headersEClass, HEADERS__HEADER);

		headerEClass = createEClass(HEADER);
		createEAttribute(headerEClass, HEADER__NAME);
		createEAttribute(headerEClass, HEADER__VALUE);

		requestBodyEClass = createEClass(REQUEST_BODY);
		createEAttribute(requestBodyEClass, REQUEST_BODY__VALUE);

		// Create enums
		requestMethodEEnum = createEEnum(REQUEST_METHOD);
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
		initEAttribute(getTestGuard_RequestMethod(), this.getRequestMethod(), "requestMethod", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGuard_Headers(), this.getHeaders(), null, "Headers", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGuard_RequestBody(), this.getRequestBody(), null, "requestBody", null, 0, 1, TestGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGuardModuleEClass, TestGuardModule.class, "TestGuardModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestGuardModule_Unit(), this.getTestGuardUnit(), null, "Unit", null, 0, -1, TestGuardModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGuardModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testGuardUnitEClass, TestGuardUnit.class, "TestGuardUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestGuardUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardUnit_Url(), ecorePackage.getEString(), "url", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardUnit_RequestBody(), ecorePackage.getEString(), "requestBody", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGuardUnit_RequestMethod(), this.getRequestMethod(), "requestMethod", null, 0, 1, TestGuardUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headersEClass, Headers.class, "Headers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHeaders_Header(), this.getHeader(), null, "Header", null, 0, -1, Headers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headerEClass, Header.class, "Header", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHeader_Name(), ecorePackage.getEString(), "name", null, 0, 1, Header.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHeader_Value(), ecorePackage.getEString(), "value", null, 0, 1, Header.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestBodyEClass, RequestBody.class, "RequestBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequestBody_Value(), ecorePackage.getEString(), "value", null, 0, 1, RequestBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(requestMethodEEnum, RequestMethod.class, "RequestMethod");
		addEEnumLiteral(requestMethodEEnum, RequestMethod.POST);
		addEEnumLiteral(requestMethodEEnum, RequestMethod.PUT);
		addEEnumLiteral(requestMethodEEnum, RequestMethod.GET);
		addEEnumLiteral(requestMethodEEnum, RequestMethod.DELETE);

		// Create resource
		createResource(eNS_URI);
	}

} //TestGuardPackageImpl
