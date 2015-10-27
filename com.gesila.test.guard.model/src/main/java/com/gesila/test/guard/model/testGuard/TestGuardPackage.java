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
	 * The feature id for the '<em><b>Module</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD__MODULE = 0;

	/**
	 * The number of structural features of the '<em>Test Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_FEATURE_COUNT = 1;

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
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GUARD_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.gesila.test.guard.model.testGuard.RequestType <em>Request Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.gesila.test.guard.model.testGuard.RequestType
	 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestType()
	 * @generated
	 */
	int REQUEST_TYPE = 3;


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
	 * Returns the meta object for the containment reference list '{@link com.gesila.test.guard.model.testGuard.TestGuard#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Module</em>'.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard#getModule()
	 * @see #getTestGuard()
	 * @generated
	 */
	EReference getTestGuard_Module();

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
	 * Returns the meta object for enum '{@link com.gesila.test.guard.model.testGuard.RequestType <em>Request Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Request Type</em>'.
	 * @see com.gesila.test.guard.model.testGuard.RequestType
	 * @generated
	 */
	EEnum getRequestType();

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
		 * The meta object literal for the '<em><b>Module</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GUARD__MODULE = eINSTANCE.getTestGuard_Module();

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
		 * The meta object literal for the '{@link com.gesila.test.guard.model.testGuard.RequestType <em>Request Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.gesila.test.guard.model.testGuard.RequestType
		 * @see com.gesila.test.guard.model.testGuard.impl.TestGuardPackageImpl#getRequestType()
		 * @generated
		 */
		EEnum REQUEST_TYPE = eINSTANCE.getRequestType();

	}

} //TestGuardPackage
