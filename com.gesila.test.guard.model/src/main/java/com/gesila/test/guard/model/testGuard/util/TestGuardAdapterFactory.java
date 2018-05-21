/**
 */
package com.gesila.test.guard.model.testGuard.util;

import com.gesila.test.guard.model.testGuard.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage
 * @generated
 */
public class TestGuardAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TestGuardPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestGuardAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TestGuardPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestGuardSwitch<Adapter> modelSwitch =
		new TestGuardSwitch<Adapter>() {
			@Override
			public Adapter caseTestGuard(TestGuard object) {
				return createTestGuardAdapter();
			}
			@Override
			public Adapter caseTestGuardModule(TestGuardModule object) {
				return createTestGuardModuleAdapter();
			}
			@Override
			public Adapter caseTestGuardUnit(TestGuardUnit object) {
				return createTestGuardUnitAdapter();
			}
			@Override
			public Adapter caseHeaders(Headers object) {
				return createHeadersAdapter();
			}
			@Override
			public Adapter caseHeader(Header object) {
				return createHeaderAdapter();
			}
			@Override
			public Adapter caseRequestBody(RequestBody object) {
				return createRequestBodyAdapter();
			}
			@Override
			public Adapter caseParams(Params object) {
				return createParamsAdapter();
			}
			@Override
			public Adapter caseParam(Param object) {
				return createParamAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.TestGuard <em>Test Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.TestGuard
	 * @generated
	 */
	public Adapter createTestGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.TestGuardModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardModule
	 * @generated
	 */
	public Adapter createTestGuardModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.TestGuardUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardUnit
	 * @generated
	 */
	public Adapter createTestGuardUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.Headers <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.Headers
	 * @generated
	 */
	public Adapter createHeadersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.Header <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.Header
	 * @generated
	 */
	public Adapter createHeaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.RequestBody <em>Request Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.RequestBody
	 * @generated
	 */
	public Adapter createRequestBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.Params <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.Params
	 * @generated
	 */
	public Adapter createParamsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.gesila.test.guard.model.testGuard.Param <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.gesila.test.guard.model.testGuard.Param
	 * @generated
	 */
	public Adapter createParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TestGuardAdapterFactory
