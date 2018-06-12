/**
 */
package com.gesila.test.guard.model.testGuard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.gesila.test.guard.model.testGuard.TestGuardFactory
 * @model kind="package"
 * @generated
 */
public interface TestGuardPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testGuard";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.igesila.com/testGuard/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testGuard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestGuardPackage eINSTANCE = com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl <em>Test Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuard()
	 * @generated
	 */
	int TEST_GUARD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__URL = 1;

	/**
	 * The feature id for the '<em><b>Request Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__REQUEST_METHOD = 2;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__HEADERS = 3;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__PARAMS = 4;

	/**
	 * The feature id for the '<em><b>Request Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__REQUEST_BODY = 5;

	/**
	 * The number of structural features of the '<em>Test Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Test Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardModuleImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuardModule()
	 * @generated
	 */
	int TEST_GUARD_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_MODULE__UNIT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_MODULE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_MODULE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardUnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardUnitImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuardUnit()
	 * @generated
	 */
	int TEST_GUARD_UNIT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT__URL = 1;

	/**
	 * The feature id for the '<em><b>Request Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT__REQUEST_BODY = 2;

	/**
	 * The feature id for the '<em><b>Request Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT__REQUEST_METHOD = 3;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.HeadersImpl <em>Headers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.HeadersImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getHeaders()
	 * @generated
	 */
	int HEADERS = 3;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADERS__HEADER = 0;

	/**
	 * The number of structural features of the '<em>Headers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADERS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Headers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADERS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.HeaderImpl <em>Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.HeaderImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getHeader()
	 * @generated
	 */
	int HEADER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.RequestBodyImpl <em>Request Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.RequestBodyImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestBody()
	 * @generated
	 */
	int REQUEST_BODY = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_BODY__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Request Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_BODY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Request Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_BODY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.ParamsImpl <em>Params</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.ParamsImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getParams()
	 * @generated
	 */
	int PARAMS = 6;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS__PARAM = 0;

	/**
	 * The number of structural features of the '<em>Params</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Params</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.impl.ParamImpl <em>Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.impl.ParamImpl
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getParam()
	 * @generated
	 */
	int PARAM = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.RequestMethod <em>Request Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.RequestMethod
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestMethod()
	 * @generated
	 */
	int REQUEST_METHOD = 8;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.EntityHeaderFields <em>Entity Header Fields</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.EntityHeaderFields
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getEntityHeaderFields()
	 * @generated
	 */
	int ENTITY_HEADER_FIELDS = 9;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.Method <em>Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.Method
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 10;

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.TestGuard <em>Test Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Guard</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard
	 * @generated
	 */
	EClass getTestGuard();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuard#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getName()
	 * @see #getTestGuard()
	 * @generated
	 */
	EAttribute getTestGuard_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuard#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getUrl()
	 * @see #getTestGuard()
	 * @generated
	 */
	EAttribute getTestGuard_Url();

	/**
	 * Returns the meta object for the containment reference '{@link com.gesila.test.guard.model.testGuard.TestGuard#getRequestBody <em>Request Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request Body</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getRequestBody()
	 * @see #getTestGuard()
	 * @generated
	 */
	EReference getTestGuard_RequestBody();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuard#getRequestMethod <em>Request Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Method</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getRequestMethod()
	 * @see #getTestGuard()
	 * @generated
	 */
	EAttribute getTestGuard_RequestMethod();

	/**
	 * Returns the meta object for the containment reference '{@link com.gesila.test.guard.model.testGuard.TestGuard#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Headers</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getHeaders()
	 * @see #getTestGuard()
	 * @generated
	 */
	EReference getTestGuard_Headers();

	/**
	 * Returns the meta object for the containment reference '{@link com.gesila.test.guard.model.testGuard.TestGuard#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Params</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getParams()
	 * @see #getTestGuard()
	 * @generated
	 */
	EReference getTestGuard_Params();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.TestGuardModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardModule
	 * @generated
	 */
	EClass getTestGuardModule();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gesila.test.guard.model.testGuard.TestGuardModule#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unit</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardModule#getUnit()
	 * @see #getTestGuardModule()
	 * @generated
	 */
	EReference getTestGuardModule_Unit();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuardModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardModule#getName()
	 * @see #getTestGuardModule()
	 * @generated
	 */
	EAttribute getTestGuardModule_Name();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit
	 * @generated
	 */
	EClass getTestGuardUnit();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit#getName()
	 * @see #getTestGuardUnit()
	 * @generated
	 */
	EAttribute getTestGuardUnit_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit#getUrl()
	 * @see #getTestGuardUnit()
	 * @generated
	 */
	EAttribute getTestGuardUnit_Url();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit#getRequestBody <em>Request Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Body</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit#getRequestBody()
	 * @see #getTestGuardUnit()
	 * @generated
	 */
	EAttribute getTestGuardUnit_RequestBody();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit#getRequestMethod <em>Request Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Method</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit#getRequestMethod()
	 * @see #getTestGuardUnit()
	 * @generated
	 */
	EAttribute getTestGuardUnit_RequestMethod();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.Headers <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Headers</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Headers
	 * @generated
	 */
	EClass getHeaders();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gesila.test.guard.model.testGuard.Headers#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Header</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Headers#getHeader()
	 * @see #getHeaders()
	 * @generated
	 */
	EReference getHeaders_Header();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Header
	 * @generated
	 */
	EClass getHeader();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.Header#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Header#getName()
	 * @see #getHeader()
	 * @generated
	 */
	EAttribute getHeader_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.Header#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Header#getValue()
	 * @see #getHeader()
	 * @generated
	 */
	EAttribute getHeader_Value();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.RequestBody <em>Request Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Body</em>'.
	 * @see com.gesila.test.guard.model.testGuard.RequestBody
	 * @generated
	 */
	EClass getRequestBody();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.RequestBody#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.gesila.test.guard.model.testGuard.RequestBody#getValue()
	 * @see #getRequestBody()
	 * @generated
	 */
	EAttribute getRequestBody_Value();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.Params <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Params</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Params
	 * @generated
	 */
	EClass getParams();

	/**
	 * Returns the meta object for the containment reference list '{@link com.gesila.test.guard.model.testGuard.Params#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Params#getParam()
	 * @see #getParams()
	 * @generated
	 */
	EReference getParams_Param();

	/**
	 * Returns the meta object for class '{@link com.gesila.test.guard.model.testGuard.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Param
	 * @generated
	 */
	EClass getParam();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.Param#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Param#getName()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.gesila.test.guard.model.testGuard.Param#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Param#getValue()
	 * @see #getParam()
	 * @generated
	 */
	EAttribute getParam_Value();

	/**
	 * Returns the meta object for enum '{@link com.gesila.test.guard.model.testGuard.RequestMethod <em>Request Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Request Method</em>'.
	 * @see com.gesila.test.guard.model.testGuard.RequestMethod
	 * @generated
	 */
	EEnum getRequestMethod();

	/**
	 * Returns the meta object for enum '{@link com.gesila.test.guard.model.testGuard.EntityHeaderFields <em>Entity Header Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Entity Header Fields</em>'.
	 * @see com.gesila.test.guard.model.testGuard.EntityHeaderFields
	 * @generated
	 */
	EEnum getEntityHeaderFields();

	/**
	 * Returns the meta object for enum '{@link com.gesila.test.guard.model.testGuard.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Method</em>'.
	 * @see com.gesila.test.guard.model.testGuard.Method
	 * @generated
	 */
	EEnum getMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestGuardFactory getTestGuardFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardImpl <em>Test Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuard()
		 * @generated
		 */
		EClass TEST_GUARD = eINSTANCE.getTestGuard();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD__NAME = eINSTANCE.getTestGuard_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD__URL = eINSTANCE.getTestGuard_Url();

		/**
		 * The meta object literal for the '<em><b>Request Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GUARD__REQUEST_BODY = eINSTANCE.getTestGuard_RequestBody();

		/**
		 * The meta object literal for the '<em><b>Request Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD__REQUEST_METHOD = eINSTANCE.getTestGuard_RequestMethod();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GUARD__HEADERS = eINSTANCE.getTestGuard_Headers();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GUARD__PARAMS = eINSTANCE.getTestGuard_Params();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardModuleImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuardModule()
		 * @generated
		 */
		EClass TEST_GUARD_MODULE = eINSTANCE.getTestGuardModule();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GUARD_MODULE__UNIT = eINSTANCE.getTestGuardModule_Unit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD_MODULE__NAME = eINSTANCE.getTestGuardModule_Name();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.TestGuardUnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardUnitImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getTestGuardUnit()
		 * @generated
		 */
		EClass TEST_GUARD_UNIT = eINSTANCE.getTestGuardUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD_UNIT__NAME = eINSTANCE.getTestGuardUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD_UNIT__URL = eINSTANCE.getTestGuardUnit_Url();

		/**
		 * The meta object literal for the '<em><b>Request Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD_UNIT__REQUEST_BODY = eINSTANCE.getTestGuardUnit_RequestBody();

		/**
		 * The meta object literal for the '<em><b>Request Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GUARD_UNIT__REQUEST_METHOD = eINSTANCE.getTestGuardUnit_RequestMethod();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.HeadersImpl <em>Headers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.HeadersImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getHeaders()
		 * @generated
		 */
		EClass HEADERS = eINSTANCE.getHeaders();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEADERS__HEADER = eINSTANCE.getHeaders_Header();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.HeaderImpl <em>Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.HeaderImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getHeader()
		 * @generated
		 */
		EClass HEADER = eINSTANCE.getHeader();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER__NAME = eINSTANCE.getHeader_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER__VALUE = eINSTANCE.getHeader_Value();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.RequestBodyImpl <em>Request Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.RequestBodyImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestBody()
		 * @generated
		 */
		EClass REQUEST_BODY = eINSTANCE.getRequestBody();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_BODY__VALUE = eINSTANCE.getRequestBody_Value();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.ParamsImpl <em>Params</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.ParamsImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getParams()
		 * @generated
		 */
		EClass PARAMS = eINSTANCE.getParams();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMS__PARAM = eINSTANCE.getParams_Param();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.impl.ParamImpl <em>Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.impl.ParamImpl
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getParam()
		 * @generated
		 */
		EClass PARAM = eINSTANCE.getParam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__NAME = eINSTANCE.getParam_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM__VALUE = eINSTANCE.getParam_Value();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.RequestMethod <em>Request Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.RequestMethod
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestMethod()
		 * @generated
		 */
		EEnum REQUEST_METHOD = eINSTANCE.getRequestMethod();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.EntityHeaderFields <em>Entity Header Fields</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.EntityHeaderFields
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getEntityHeaderFields()
		 * @generated
		 */
		EEnum ENTITY_HEADER_FIELDS = eINSTANCE.getEntityHeaderFields();

		/**
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.Method <em>Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.Method
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getMethod()
		 * @generated
		 */
		EEnum METHOD = eINSTANCE.getMethod();

	}

} //TestGuardPackage
